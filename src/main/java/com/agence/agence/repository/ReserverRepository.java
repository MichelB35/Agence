package com.agence.agence.repository;

import com.agence.agence.models.Reservation;
import com.agence.agence.models.Reserver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ReserverRepository extends JpaRepository<Reservation,Integer> {
    @Query("SELECT count(*)FROM Reservation")
    int countIdReservation();

    @Query("SELECT sum(prix)FROM Reservation")
    int countPrix();

    @Query("SELECT count(*) FROM Reservation  WHERE typeVehicule = 'caminion'")
    int countTypeCaminion ();

    @Query("SELECT count(*) FROM Reservation  WHERE typeVehicule = 'vehicule'")
    int countTypeVehicule ();
    @Query("SELECT count(*) FROM Reservation WHERE typeVehicule = 'moto'")
    int countNombreMoto();
}
