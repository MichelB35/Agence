package com.agence.agence.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idReservation;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dayAction = LocalDateTime.now();
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dateDebut;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dateFin;
    @ManyToOne
    @JoinColumn(name = "idUser")
    private  User user;
    @ManyToOne
    @JoinColumn(name = "idVehicule")
    private  Vehicule vehicule;
    private String statut;
    private String time;
    private String typeVehicule;
    @Min(45)
    private double prix = 45;
}
