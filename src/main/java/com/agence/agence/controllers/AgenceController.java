package com.agence.agence.controllers;

import com.agence.agence.models.Agence;
import com.agence.agence.service.AgenceService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.nio.file.StandardCopyOption;
import java.util.List;

@Controller
@RequestMapping("/agence")
public class AgenceController {

    @Autowired
    AgenceService agenceService;

    final String     UPLOADDIR = "src\\main\\resources\\static\\assets\\img\\cars";
    @GetMapping("/add")
    public String add(Model model, HttpSession session){


        model.addAttribute("agence", new Agence());

        return "agence/add";
    }

    @PostMapping("/add")
    public String addAgence(@Valid Agence agence,
                            @RequestParam( "photo" ) MultipartFile photo,
                            BindingResult result,
                            RedirectAttributes redirectAttributes,
                            Model model) throws IOException {
        System.out.println(agence);
        System.out.println(result);


        if(result.hasErrors()){
            redirectAttributes.addAttribute("agence",new Agence());
            return "agence/add";
        }else{
            
            agenceService.add(agence);
            redirectAttributes.addAttribute("success" ,"agence enregistrer");
        }
        return "redirect:/";
    }

    public Agence Agence11 (int id){
        return agenceService.findById(id);
    }

    @GetMapping("/find/{id}")
    public String getById( @PathVariable int id,Model model){
        if(id!=0) {
            Agence agence = agenceService.findById(id);
            model.addAttribute("agence",agence);
        }

        return  "agence/find";
    }

    @GetMapping("/delete/{id}")
    public void deleteAgence(@PathVariable int id, RedirectAttributes redirectAttributes){
        System.out.println(id);
        if (id !=0){
            agenceService.delete(id);
        }
        redirectAttributes.addAttribute("unfind","pas d'agence retrouver");
    }

    @GetMapping("/list")
    public String getAllAgence(Model model,RedirectAttributes redirectAttributes){
        List<Agence> agences = agenceService.list();
        if(agences.isEmpty()){
            redirectAttributes.addAttribute("unfind","pas d'agence de trouver");
        }
        model.addAttribute("agences",agences);
        return "agence/list";
    }

}
