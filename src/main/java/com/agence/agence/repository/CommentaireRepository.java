package com.agence.agence.repository;

import com.agence.agence.models.Commentaire;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentaireRepository extends JpaRepository<Commentaire,Integer> {
}
