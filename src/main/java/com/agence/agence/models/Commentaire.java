package com.agence.agence.models;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;
import java.time.LocalTime;

/***
 * by : Michel
 * nature :  entity User
 */
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Commentaire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCommentaire;

    @Size(min = 1,  max = 100)
    @Column(nullable = false, length = 100)
    private String contenu;

    @Column(nullable = false)
    private LocalDate localDate;

    @Column(nullable = false)
    private LocalTime localTime;

    @ManyToOne
    @JoinColumn(name = "idUser")
    private User user;

    @ManyToOne
    @JoinColumn(name = "idVehicule" )
    private  Vehicule vehicule;


}
