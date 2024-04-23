package com.agence.agence.repository;

import com.agence.agence.models.Calendrier;
import com.agence.agence.models.User;
import com.agence.agence.models.Vehicule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;

public interface CalendrierRepository extends JpaRepository<Calendrier,Integer> {
   Calendrier findByLocalDateDebutReservationAndLocalDateFinReservation(LocalDateTime LocalDateDebutReservation, LocalDateTime LocalDateFinReservation);
   Calendrier findByUserAndVehiculeAndLocalDateDebutReservation(User user, Vehicule vehicule,LocalDateTime LocalDateDebutReservation);
}
