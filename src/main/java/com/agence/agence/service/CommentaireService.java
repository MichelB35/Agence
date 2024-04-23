package com.agence.agence.service;

import com.agence.agence.models.Commentaire;
import com.agence.agence.repository.CommentaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentaireService implements  ServiceInterface<Commentaire> {
    @Autowired
    CommentaireRepository commentaireRepository;
    @Override
    public Commentaire add(Commentaire commentaire) {
        return commentaireRepository.save(commentaire);
    }

    @Override
    public void delete(int id) {
        Commentaire commentaire = commentaireRepository.findById(id).get();
        if(commentaire != null){
            commentaireRepository.delete(commentaire);
        }

    }

    @Override
    public Commentaire update(Commentaire commentaire) {
        return null;
    }

    @Override
    public Commentaire findById(Integer id) {
        Optional<Commentaire>commentaire = commentaireRepository.findById(id);
        return null;
    }

    @Override
    public List<Commentaire> list() {
        return commentaireRepository.findAll();
    }
}
