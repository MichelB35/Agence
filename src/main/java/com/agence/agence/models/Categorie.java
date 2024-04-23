package com.agence.agence.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;

/***
 * by : Michel
 * nature : entity Categorie
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Categorie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCategorie;

    @Size(min = 2, max = 15)
    @Column(nullable = false, unique = true,  length = 15)
    private String type;


    @Min(2)@Max(4)
    @Column( nullable = false, length =  1)
    private int nombreDeRoue;

    //@Min(0)@Max(5)
    @Column(nullable = false, length =  1)
    private int nombrePorte;

    @OneToMany(mappedBy = "idVehicule")
    List <Vehicule>vehicules;
}
