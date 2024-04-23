package com.agence.agence.controllers;

import com.agence.agence.models.Calendrier;
import com.agence.agence.service.CalendrierService;
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
@RequestMapping("/calendrier")
public class CalendrierController {
    @Autowired
    CalendrierService calendrierService;
    @GetMapping("/add")
    public String addCalendrier(Model model){
        model.addAttribute("calendrier",new Calendrier());
        return "calendrier/add";
    }

    @PostMapping("/add")
    public String addCalendrier(@Valid Calendrier calendrier, BindingResult result, RedirectAttributes redirectAttributes, Model model){
        if(result.hasErrors()){
            model.addAttribute("calendrier", new Calendrier());
            redirectAttributes.addAttribute("unfind","pas de calendrier retrouver");
        }else{
            calendrierService.add(calendrier);
            redirectAttributes.addAttribute("success","bien");
        }
        return "calendrier/add";
    }

    @GetMapping("delete/{id}")
    public void deleteCalendrier(@PathVariable int id){
       if(id != 0){
           calendrierService.delete(id);
       }
    }

    @GetMapping("/findById")
    public Calendrier getById(@PathVariable int id){
        Calendrier calendrier = calendrierService.findById(id);
        return calendrier;
    }

}
