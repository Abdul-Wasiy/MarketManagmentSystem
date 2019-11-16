package hu.cs.se.controller;


import hu.cs.se.model.Permission;
import hu.cs.se.model.Role;
import hu.cs.se.model.User;
import hu.cs.se.service.PermissionService;
import hu.cs.se.service.RoleService;
import hu.cs.se.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private PermissionService permissionService;

    @GetMapping("/login")
    public String Login(){
        return "login";
    }

    @GetMapping("/user/register")
    public String getRegisterPage(Model model){
        model.addAttribute("user",new User());
        model.addAttribute("roles",roleService.findAllRoles());
        model.addAttribute("permissions", permissionService.findAllPermissions());
        return "user/user-form";
    }


    @PostMapping("/user/register")
    public String register(@ModelAttribute User user, @RequestParam List<Integer>roleIds, @RequestParam List<Integer>permissionIds){
       if(!permissionIds.isEmpty()){
           permissionIds.remove(0);
          List<Permission> permissions = permissionService.findAllPermissionsById(permissionIds);
          user.setPermissions(new HashSet<>(permissions));
       }
       List<Role> roles = roleService.findAllRolesByIds(roleIds);
       user.setRoles(new HashSet<>(roles));
//        userService.saveUser(user);
        userService.createUser(user);
        return "redirect:/user/list";
    }
    @RequestMapping(path = "/user/list", method = RequestMethod.GET )
    public String getUserListPage(Model model){
        model.addAttribute("users",userService.findAll());
        return "user-list";
    }

    @GetMapping("/user/edit/{id}")
    public String editUser(@PathVariable Long id, Model model){
        User user = userService.findUserById(id);
        model.addAttribute("user",user);
        return "user-form";
    }
    @PostMapping("/user/delete/{id}")
    public String deleteUser(@PathVariable Long id){
        userService.deleteUserById(id);
        return "redirect:/user/list";
    }
}
