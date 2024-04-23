package com.agence.agence.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

/***
 * by: Michel
 * nature : entity Calendrier
 */
@ToString
@Getter
@Setter
@Entity
public class Vehicule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idVehicule;

    @Column(nullable = false, unique = true)
    private String marque;

    @Column(nullable = false)
    private String alimentation;

    @Column(nullable = false)
    private String couleur;

    @Column(nullable = false)
    private String type;

    @Column(length = 5)
    private String longueur;

    @Size(min = 8 , max = 15)
    @Column(nullable = false, unique = true,length = 15)
    private String matricule;

    @Column(length = 5)
    private String poids;


    @Column(nullable = false)
    private  double prix;


    @OneToMany(mappedBy = "vehicule")
    List<Commentaire> commentaire;

    @OneToMany(mappedBy = "vehicule")
    List<Reservation> reservations;

    @ManyToOne
    @JoinColumn(name = "idAgence")
    private  Agence agence;

    @ManyToOne
    @JoinColumn(name = "categorie")
    private Categorie categorie;

    @OneToMany(mappedBy = "vehicule")
    List<Calendrier> calendriers;

    @ManyToMany
    @JoinTable(name = "Reserver", joinColumns = @JoinColumn(name = "idVehicule"),
            inverseJoinColumns = @JoinColumn(name = "idUser"))
    private List<User> users;


    @ManyToMany(mappedBy = "vehicules")
    private List<Calendrier> calendrier;

}
