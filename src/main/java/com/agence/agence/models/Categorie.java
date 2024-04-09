package com.agence.agence.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

/***
 * by : Michel
 * nature : entity Categorie
 */
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Categorie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCategorie;

    @Size(min = 2, max = 15)
    @Column(nullable = false, unique = false, length = 15)
    private String type;

    @Size(min = 1)
    @Column(unique = true, nullable = false, length =  1)
    private String nombreDeRoue;

    @Size(min = 1)
    @Column(nullable = false, length =  1)
    private String nombrePorte;

    @OneToMany(mappedBy = "idVehicule")
    List <Vehicule>vehicules;
}
