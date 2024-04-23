package com.agence.agence.controllers;

import com.agence.agence.service.*;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @Autowired
    CategorieService categorieService;
    @Autowired
    AgenceService agenceService;
    @Autowired
    VehiculeService vehiculeService;
    @Autowired
    UserService userService;
    @Autowired
    ReserverService reserverService;


    @GetMapping("/")
    public  String home(Model model,HttpSession session){
        model.addAttribute("categorie",categorieService.list());
        System.out.println(agenceService.count());
        System.out.println(userService.count());
        System.out.println(categorieService.count());
        System.out.println(vehiculeService.countDeuxRoue());
        System.out.println(vehiculeService.countQuatreRoue());
        System.out.println(vehiculeService.prixTotal());
        System.out.println(reserverService.prixTotale());
        System.out.println(vehiculeService.countv());
        System.out.println( agenceService.findById(11).getVehicules().size());
        System.out.println( agenceService.findById(1).getVehicules().size());

        return "index";
    }

    @GetMapping("/dashbord")
    public  String dashbord(Model model){
        model.addAttribute("deuxRoues",vehiculeService.countDeuxRoue());
        model.addAttribute("quatreRoues",vehiculeService.countQuatreRoue());
        model.addAttribute("vehiculeCount",vehiculeService.countv());
        model.addAttribute("vehicules", vehiculeService.list());
        model.addAttribute("prixTotale", reserverService.prixTotale());
        model.addAttribute("userCount", userService.count());
        model.addAttribute("vehiculeV",vehiculeService.countVehicule());
        model.addAttribute("categorieCount",categorieService.count());
        model.addAttribute("agenceCount", agenceService.count());
        model.addAttribute("userAdmin", userService.userAdmin());
        model.addAttribute("userUser", userService.userUser());
        model.addAttribute("list11",agenceService.findById(11));
        model.addAttribute("list1",agenceService.findById(1));
        int atotal = vehiculeService.countv();
        int a = agenceService.findById(11).getVehicules().size();
        int a1 = agenceService.findById(1).getVehicules().size();

        int som =  reserverService.nombreReservationTotal();
        int cam = reserverService.nombreCaminion();
        int  veh = reserverService.nombreVehicule();
        int moto = reserverService.nombreMoto();
        System.out.println(pourcentage(a,som));
        System.out.println(pourcentage(a1,som));

        model.addAttribute("pV", pourcentage(veh,som));
        model.addAttribute("pC", pourcentage(cam,som));
        model.addAttribute("pM", pourcentage(moto,som));

        model.addAttribute("agence11", pourcentage(a,som));
        model.addAttribute("agence1", pourcentage(a1,som));



        return "admin/index";
    }

    public  int pourcentage(int byType,int div){
        return ((byType*100)/(div));
    }
}
