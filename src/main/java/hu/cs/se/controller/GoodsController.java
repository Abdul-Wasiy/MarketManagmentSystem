package hu.cs.se.controller;


import hu.cs.se.model.Good;
import hu.cs.se.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @GetMapping("/good/register")
    public String getRegisterPage(Model model){
        model.addAttribute("good",new Good());

        return "good-form";
    }

    @PostMapping("/good/register")
    public String register(@ModelAttribute Good good){
        goodsService.saveGoods(good);

        return "redirect:/good/register";
    }
    @RequestMapping(path = "/good/list"  , method = RequestMethod.GET )
    public String getGoodsListPage(Model model){
        model.addAttribute("goods",goodsService.findAll());
        return "good-list";
    }

    @GetMapping("/good/edit/{id}")
    public String editGood(@PathVariable Long id, Model model){
        Good good = goodsService.findGoodsById(id);
        model.addAttribute("good",good);
        return "good-form";
    }
    @PostMapping("/good/delete/{id}")
    public String deleteGood(@PathVariable Long id){
        goodsService.deleteGoodsById(id);
        return "redirect:/good/list";
    }
}
