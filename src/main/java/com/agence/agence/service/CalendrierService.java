package com.agence.agence.service;

import com.agence.agence.models.Calendrier;
import com.agence.agence.models.User;
import com.agence.agence.models.Vehicule;
import com.agence.agence.repository.CalendrierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class CalendrierService implements ServiceInterface<Calendrier> {

    @Autowired
    CalendrierRepository calendrierRepository;
    @Override
    public Calendrier add(Calendrier calendrier) {
        return calendrierRepository.save(calendrier);
    }

    @Override
    public void delete(int id) {

        Calendrier calendrier = calendrierRepository.findById(id).get();
        if(calendrier!=null){
            calendrierRepository.delete(calendrier);
        }

    }

    public  Calendrier findByDate( LocalDateTime date,
                           LocalDateTime dateF){
        return calendrierRepository.findByLocalDateDebutReservationAndLocalDateFinReservation(date,dateF);
    }

    @Override
    public Calendrier update(Calendrier calendrier) {
        return null;
    }


    @Override
    public Calendrier findById(Integer id) {
        Optional<Calendrier> calendrier1 =  calendrierRepository.findById(id);
        return calendrier1.isPresent()?calendrier1.get() :null;
    }

    @Override
    public List<Calendrier> list() {
        return calendrierRepository.findAll();
    }
}
