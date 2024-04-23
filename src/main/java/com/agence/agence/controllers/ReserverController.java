package com.agence.agence.controllers;

import com.agence.agence.models.*;
import com.agence.agence.repository.ReserverRepository;
import com.agence.agence.service.CalendrierService;
import com.agence.agence.service.ReserverService;
import com.agence.agence.service.UserService;
import com.agence.agence.service.VehiculeService;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.apache.coyote.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.util.Date;

@Controller
@RequestMapping("/reserver")
public class ReserverController {
    @Autowired
    ReserverService reserverService;

    @Autowired
    CalendrierService calendrierService;
    @Autowired
    UserService userService;

    @Autowired
    VehiculeService vehiculeService;

    @GetMapping("/")
    public  String add(Model model,Reservation reserver,@Param("time") String time,HttpSession session, Vehicule vehicule){

        model.addAttribute("reserver",new Reservation());
        return "calendrier/add";
    }
    @GetMapping("/getById/{id}")
    public Reservation getById(@PathVariable int id, RedirectAttributes redirectAttributes){
        if(id!=0) {
            Reservation reservation = reserverService.findById(id);
            return reservation;
        }

        return  null;
    }

    @GetMapping("/delete/{id}")
    public void deleteReservation(@PathVariable int id, RedirectAttributes redirectAttributes){
        System.out.println(id);
        if (id !=0){
            reserverService.delete(id);
        }
        redirectAttributes.addAttribute("unfind","pas d'agence retrouver");
    }


    @GetMapping("/list")
    public  String list(Model model,HttpSession session){
        try {
            session.setAttribute("prixTotal", reserverService.prixTotale());
            model.addAttribute("reservers", reserverService.list());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return "calendrier/list";
    }

    @PostMapping("/add")
    public String add( @Valid Reservation reserver,
                      RedirectAttributes redirectAttributes,
                      BindingResult result,
                      @Param("idUser") Integer idUser,
                      @Param("prix") Double prix,
                      @Param("idVehicule") Integer idVehicule,
                      HttpSession session,
                      Model model){



            try{
                if (idUser!=null && idVehicule != null && prix !=null){
                    User idU =  userService.findById(idUser);
                    Vehicule idV =vehiculeService.findById( idVehicule);
                    System.out.println(idV.getType());
                    System.out.println(idV);

                    reserver.setTypeVehicule(idV.getType());
                    reserver.setUser(idU);
                    reserver.setVehicule(idV);
                    reserver.setPrix(prix);
                    reserver.setStatut("occupé");

                    if(result.hasErrors()) {
                        System.out.println("faulte");
                        model.addAttribute("reserver",new Reservation());
                        return"calendrier/add";
                    }else {
                        reserverService.add(reserver);
                        redirectAttributes.addAttribute("success","Utilisateur crée");
                    }

                }
            }catch (Exception e){
                System.out.println(e.getMessage());
            }


        return "redirect:/";
    }

    public  Double calculePrix( Vehicule vehicule, Reserver reserver,String heure){
        double prixLocation = 0;
        heure ="0";
        if( reserver.getLocalDateDebutReservation()==reserver.getLocalDateFinReservation()) {
           return prixLocation = Integer.parseInt( heure) * vehicule.getPrix();
        }
        int nbrDay = reserver.getLocalDateDebutReservation().compareTo(reserver.getLocalDateFinReservation());
        return  prixLocation = reserver.getPrix() * vehicule.getPrix();

    }
}
