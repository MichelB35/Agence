package com.agence.agence.controllers;

import com.agence.agence.models.Categorie;
import com.agence.agence.service.CategorieService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.awt.desktop.QuitStrategy;
import java.util.List;

@Controller
@RequestMapping("/categorie")
public class CategorieController {
    @Autowired
    CategorieService categorieService;

    @GetMapping("/detail/{id}")
    public String getById (@PathVariable int id, Model model){
        Categorie categorie = categorieService.findById(id);
        model.addAttribute("categorie",  categorie);
        return  "categorie/detail";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id){
        categorieService.delete(id);
        return "categorie/search";
    }


    @GetMapping("/add")
    public String add(Model model, HttpSession session){
        model.addAttribute("categorie", new Categorie());
        session.setAttribute("categorieCount",categorieService.count());
        return "categorie/add";
    }
    @GetMapping("/list")
    public String list (Model model) {
        model.addAttribute("categories", categorieService.list());
        return "categorie/find";
    }

    @GetMapping("/search")
    public String  search(@Param("keyword") String keyword,Model model){
        model.addAttribute("search", categorieService.sheach(keyword));
        model.addAttribute("categories", categorieService.list());
        return "categorie/search";
    }
    @PostMapping("/addCategorie")
    public String add(@Valid Categorie  categorie, BindingResult result, RedirectAttributes redirectAttributes,Model model){
        System.out.println(categorie);
        System.out.println(result);
        if(result.hasErrors()){
            model.addAttribute("categorie",new Categorie());
            model.addAttribute("error","pensez à bien valider les champs");
        }else{
            try{
                System.out.println("categorie");
                categorieService.add(categorie);
            }catch (Exception e){
                System.out.println(e.getMessage());
                return  "categorie/add";
            }

        }
        return "categorie/add";
    }
}
