package com.agence.agence.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;
import java.time.LocalTime;
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
public class Calendrier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCalendrier;

    @Column(nullable = false)
    private LocalDate localDate;

    @Column(nullable = false)
    private LocalTime localTime;

    @ManyToMany
    @JoinTable(name = "Reserver", joinColumns = @JoinColumn(name = "idVehicule"),
            inverseJoinColumns = @JoinColumn(name = "idCalendrier"))
    private List<Vehicule> vehicules;

    @ManyToMany(mappedBy = "calendars")
    private List<User> users;
}
