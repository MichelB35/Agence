package com.agence.agence.controllers;

import com.agence.agence.models.Reservation;
import com.agence.agence.models.Reserver;
import com.agence.agence.models.Vehicule;
import com.agence.agence.service.AgenceService;
import com.agence.agence.service.CategorieService;
import com.agence.agence.service.VehiculeService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/vehicule")
public class VehiculeController {

    @Autowired
    AgenceService agenceService;
    @Autowired
    CategorieService categorieService;
    @Autowired
    VehiculeService vehiculeService;

    @GetMapping("/add")
    public String add(Model model){
        model.addAttribute("vehicule",new Vehicule());
        model.addAttribute("agences",agenceService.list());
        model.addAttribute("categories",categorieService.list());
        System.out.println(vehiculeService.countDeuxRoue());
        System.out.println(vehiculeService.countQuatreRoue());

        return "vehicule/add";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id){
        vehiculeService.delete(id);
        return "vehicule/list";
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable int id,Model model){
        Vehicule vehicule =  vehiculeService.findById(id);
        model.addAttribute("vehicule",vehicule);
        return "vehicule/detail";
    }

    @GetMapping("/reserver/{id}")
    public String reserver(@PathVariable int id,
                           Model model,
                           HttpSession session){
        Vehicule vehicule =  vehiculeService.findById(id);
        session.setAttribute("vehiculeId",vehicule);
        model.addAttribute("reserver",new Reservation());
        return "calendrier/add";
    }

    @GetMapping("/list")
    public String getAll(Model model){

        return "vehicule/list";
    }

    @GetMapping("/card")
    public String card(Model model){
        model.addAttribute("vehicules", vehiculeService.list());
        return "vehicule/card";
    }

    @PostMapping
    public String add(@Valid Vehicule vehicule, BindingResult result, RedirectAttributes redirectAttributes,Model model){
        System.out.println(vehicule);
        System.out.println(result);
        if(result.hasErrors()){
            redirectAttributes.addAttribute("error","pensez à remplir tous les champs");
            model.addAttribute("vehicule", new Vehicule());
        }else{
            vehiculeService.add(vehicule);
            redirectAttributes.addAttribute("success","véhicule enregistrer avec succes");
        }
        return"vehicule/add";
    }
}
