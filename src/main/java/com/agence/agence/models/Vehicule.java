package com.agence.agence.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/***
 * by: Michel
 * nature : entity Calendrier
 */
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Vehicule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idVehicule;

    @Column(nullable = false, unique = true)
    private String Couleur;

    @Column(length = 5)
    private String longueur;

    @Size(min = 8 , max = 15)
    @Column(nullable = false, unique = false,length = 15)
    private String matricule;

    @Column(length = 5)
    private String poids;

    @OneToMany(mappedBy = "vehicule")
    List<Commentaire> commentaire;

    @ManyToOne
    @JoinColumn(name = "idAgence")
    private  Agence agence;

    @ManyToOne
    @JoinColumn(name = "categorie")
    private Categorie categorie;

    @ManyToMany
    @JoinTable(name = "Reserver", joinColumns = @JoinColumn(name = "idVehicule"),
            inverseJoinColumns = @JoinColumn(name = "idUser"))
    private List<User> users;


    @ManyToMany(mappedBy = "vehicules")
    private List<Calendrier> calendriers;

}
