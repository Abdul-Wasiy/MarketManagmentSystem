package hu.cs.se.controller;

import hu.cs.se.model.Customer;
import hu.cs.se.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/customer/register")
    public String getRegisterPage(Model model){
        model.addAttribute("customer",new Customer());

        return "customer-form";
    }

    @PostMapping("/customer/register")
    public String register(@ModelAttribute Customer customer){
        customerService.saveCustomer(customer);

        return "redirect:/customer/register";
    }
    @RequestMapping(path = {"/customer/list" , "/"} , method = RequestMethod.GET )
    public String getCustomerListPage(Model model){
        model.addAttribute("customers",customerService.findAll());
        return "customer-list";
    }

    @GetMapping("/customer/edit/{id}")
    public String editCustomer(@PathVariable Long id, Model model){
        Customer customer = customerService.findCustomerById(id);
        model.addAttribute("customer",customer);
        return "customer-form";
    }
    @PostMapping("/customer/delete/{id}")
    public String deleteCustomer(@PathVariable Long id){
        customerService.deleteCustomerById(id);
        return "redirect:/customer/list";
    }
}
