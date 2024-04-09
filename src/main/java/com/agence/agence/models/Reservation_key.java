package com.agence.agence.models;

import jakarta.persistence.Embeddable;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
//@EqualsAndHashCode
@Embeddable
public class Reservation_key {
    private int idUser;

    private int  idCalendrier;

    private int idVehicule;
}
