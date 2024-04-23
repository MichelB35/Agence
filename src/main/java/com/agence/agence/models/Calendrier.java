package com.agence.agence.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
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
    private Integer idCalendrier;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDate localDateAction =LocalDate.now() ;


    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime localDateDebutReservation;


    @DateTimeFormat(pattern = "yyyy-MM-dd  HH:mm:ss")
    private LocalDateTime localDateFinReservation;

    private String time;

    @ManyToOne
    @JoinColumn(name = "idUser")
    private User user;

    @ManyToOne
    @JoinColumn(name = "idVehicule")
    private Vehicule vehicule;

    public Calendrier( LocalDateTime localDateDebutReservation, LocalDateTime localDateFinReservation,String time,User user,Vehicule vehicule){
       this.localDateAction =LocalDate.now();
       this.localDateDebutReservation =localDateDebutReservation;
       this.localDateFinReservation =localDateFinReservation;
       this.time =time;
    }

    @ManyToMany
    @JoinTable(name = "Reserver", joinColumns = @JoinColumn(name = "idVehicule"),
            inverseJoinColumns = @JoinColumn(name = "idCalendrier"))
    private List<Vehicule> vehicules;

    @ManyToMany(mappedBy = "calendars")
    private List<User> users;
}
