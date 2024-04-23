package com.agence.agence.repository;

import com.agence.agence.models.Agence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AgenceRepository extends JpaRepository<Agence,Integer> {
    @Query("SELECT count(*) FROM Agence")
    int countIdAgence();


}
