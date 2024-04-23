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
 * nature : entity Agence
 */
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Agence {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idAgence;

    @Size(min = 8)
    @Column(nullable = false, unique = true, length = 15)
    private String matriculeAgence;

    @Size(min = 2,  max = 30)
    @Column(unique = true,nullable = false, length = 30)
    private String nomAgence;


    @OneToMany(mappedBy = "agence")
    private List <Vehicule> vehicules;

}
