package com.agence.agence.service;
import com.agence.agence.models.Agence;
import com.agence.agence.repository.AgenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AgenceService implements ServiceInterface<Agence>{
   @Autowired
    AgenceRepository agenceRepository;
    @Override
    public Agence add(Agence agence) {
        return agenceRepository.save(agence);
    }

    public int count(){
        return agenceRepository.countIdAgence();
    }




    @Override
    public void delete(int id) {
        Agence agence= agenceRepository.findById(id).get();
        if(agence != null) {
            agenceRepository.delete(agence);
        }

    }

    @Override
    public Agence update(Agence agence) {
        return agence;
    }

    @Override
    public Agence findById(Integer id) {
        Optional<Agence> agence1 = agenceRepository.findById(id);
        return agence1.isPresent()?agence1.get():null;
    }

    @Override
    public List<Agence> list() {
        return agenceRepository.findAll() ;
    }
}
