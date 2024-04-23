package com.agence.agence.service;

import com.agence.agence.models.Categorie;
import com.agence.agence.repository.CategorieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategorieService implements  ServiceInterface<Categorie>{
    @Autowired
    CategorieRepository categorieRepository;
    @Override
    public Categorie add(Categorie categorie) {
        return categorieRepository.save(categorie);
    }

    @Override
    public void delete(int id) {

        Categorie categorie = categorieRepository.findById(id).get();
        if(categorie!=null){
            categorieRepository.delete(categorie);
        }

    }

    @Override
    public Categorie update(Categorie categorie) {
        return null;
    }

    @Override
    public Categorie findById(Integer id) {
        Optional<Categorie> categorie1 = categorieRepository.findById(id);
        return categorie1.isPresent()?categorie1.get():null;
    }

    public int count(){
        return  categorieRepository.countIdCategorie();
    }
    @Override
    public List<Categorie> list() {
        return categorieRepository.findAll();
    }

    public List<Categorie>sheach(String keyword){
        return  categorieRepository.findAll(keyword);
    }
}
