package com.agence.agence.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

@Embeddable
public class Reserver {

    @EmbeddedId
private Reservation_key idReserver;

@ManyToOne
@JoinColumn(name = "user_id_user")
private User user;
@ManyToOne
@JoinColumn(name = "vehicule_id_vehicule")
private Vehicule vehicule;
private LocalDate localDate;
private LocalTime localTime;


}
