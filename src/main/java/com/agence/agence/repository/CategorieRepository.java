package com.agence.agence.repository;

import com.agence.agence.models.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategorieRepository extends JpaRepository<Categorie,Integer> {
    @Query("SELECT c FROM Categorie c WHERE CONCAT(c.idCategorie,c.type,c.nombreDeRoue,c.nombrePorte) LIKE %?1%")
     List<Categorie> findAll(String keyword);

    @Query("SELECT count(*) FROM Categorie")
    int countIdCategorie();
}
