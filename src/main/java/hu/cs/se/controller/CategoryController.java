package hu.cs.se.controller;

import hu.cs.se.model.Customer;
import hu.cs.se.model.MyCategory;
import hu.cs.se.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/category/register")
    public String getRegisterPage(Model model){
        model.addAttribute("category",new MyCategory());

        return "category-form";
    }

    @PostMapping("/category/register")
    public String register(@ModelAttribute MyCategory myCategory){
        categoryService.saveCategory(myCategory);

        return "redirect:/category/register";
    }
    @RequestMapping(path = "/category/list", method = RequestMethod.GET )
    public String getCategoryListPage(Model model){
        model.addAttribute("categories", categoryService.findAll());
        return "category-list";
    }

    @GetMapping("/category/edit/{id}")
    public String editCategory(@PathVariable Long id, Model model){
        MyCategory myCategory = categoryService.findCategoryById(   id);
        model.addAttribute("category",myCategory);
        return "category-form";
    }
    @PostMapping("/category/delete/{id}")
    public String deleteCategory(@PathVariable Long id){
        categoryService.deleteCategoryById(id);
        return "redirect:/category/list";
    }
}
