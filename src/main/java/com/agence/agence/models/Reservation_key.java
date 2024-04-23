package com.agence.agence.models;

import jakarta.persistence.Embeddable;
import lombok.*;
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
//@EqualsAndHashCode
@Embeddable
public class Reservation_key {
    private Integer idUser;

    private Integer  idCalendrier;

    private Integer idVehicule;
}
