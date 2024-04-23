package com.agence.agence.repository;

import com.agence.agence.models.Vehicule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VehiculeRepository extends JpaRepository<Vehicule,Integer> {
    @Query("SELECT count(*) FROM Vehicule")
    int countIdVehicule();


    @Query("SELECT SUM(prix) FROM Vehicule")
    int countPrix();
    @Query("SELECT count(*) FROM Vehicule  WHERE type = 'caminion'")
    int countNombreDeRoue2 ();

    @Query("SELECT count(*) FROM Vehicule  WHERE type = 'vehicule'")
    int countNombreDeRoueVehicule ();
    @Query("SELECT count(*) FROM Vehicule WHERE type = 'moto'")
    int countNombreDeRoue4();
}
