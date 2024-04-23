package com.agence.agence.service;

import com.agence.agence.models.Reservation;
import com.agence.agence.models.Reservation_key;
import com.agence.agence.models.Reserver;
import com.agence.agence.repository.ReserverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReserverService implements  ServiceInterface <Reservation>{
    @Autowired
    ReserverRepository reserverRepository;
    @Override
    public Reservation add(Reservation reserver) {
        return reserverRepository.save(reserver);
    }

    @Override
    public void delete(int id) {
        Reservation reserver= reserverRepository.findById(id).get();
        if(reserver!=null){
            reserverRepository.delete(reserver);
        }


    }



    @Override
    public Reservation update(Reservation reserver) {
        return null;
    }


    @Override
    public Reservation findById(Integer id) {
        Optional<Reservation> reserver = reserverRepository.findById(id);
        return reserver.isPresent()?reserver.get():null;
    }

    public int prixTotale(){
        return reserverRepository.countPrix();
    }
    public  int nombreReservationTotal(){
        return  reserverRepository.countIdReservation();
    }
    public  int nombreMoto(){
        return reserverRepository.countNombreMoto();
    }

    public  int nombreVehicule(){
        return reserverRepository.countTypeVehicule();
    }
    public  int nombreCaminion(){
        return reserverRepository.countTypeCaminion();
    }

    @Override
    public List list() {
        return reserverRepository.findAll();
    }
}
