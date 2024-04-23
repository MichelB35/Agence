package com.agence.agence.controllers;

import com.agence.agence.models.User;
import com.agence.agence.repository.UserRepository;
import com.agence.agence.service.UserService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    UserRepository userRepository;



    @GetMapping("/logon")
    public String logon(Model model) {
        model.addAttribute("user", new User());
        return "/user/add";

    }

    @GetMapping("/find")
    public String find() {
        return "find";
    }

    @PostMapping("/add")
    public String add(@Valid User user,BindingResult result, RedirectAttributes redirectAttributes, Model model){
        System.out.println(user);
        System.out.println(result);
        System.out.println(userService.count());

        if(result.hasErrors()) {
            System.out.println("faulte");
            model.addAttribute("user","");
            return"user/add";
        }
            userService.add(user);
            redirectAttributes.addAttribute("success","Utilisateur crée");

        return "redirect:/";
    }


    @GetMapping( "/login" )
    public String login() {
        return "user/login";
    }


    @PostMapping("/check")
    public String check (@Param("login") String login, @Param("mdp") String mdp, Model model, HttpSession httpSession){
       try {
           User u = userRepository.findByLoginAndMdp(login,mdp);
           System.out.println(u);
           if(u != null){
               httpSession.setAttribute("userLogin",u);





           }
       }catch (Exception e){
           System.out.println(e.getMessage());
           return "user/login";
       }

        return "redirect:/";
    }

    @GetMapping("/logout")
    public String logout (HttpSession httpSession){
        httpSession.invalidate();
        return "redirect:/";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id){
        if(id != 0){
            userService.delete(id);
        }
        return "redirect:/";
    }

    @GetMapping("/list")
    public  String getAll(Model model){
        model.addAttribute("users",userService.list());
        return "user/find";
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable int id,Model model){
        User user = userService.findById(id);
        model.addAttribute("user",user);
        return "user/detail";

    }
}
