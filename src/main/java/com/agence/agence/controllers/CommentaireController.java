package com.agence.agence.controllers;

import com.agence.agence.service.CommentaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/commentaire")
@Controller
public class CommentaireController {
    @Autowired
    CommentaireService commentaireService;

}
