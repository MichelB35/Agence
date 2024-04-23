package com.agence.agence.service;

import com.agence.agence.models.Vehicule;
import com.agence.agence.repository.VehiculeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehiculeService implements  ServiceInterface<Vehicule>{
    @Autowired
    VehiculeRepository vehiculeRepository;
    @Override
    public Vehicule add(Vehicule vehicule) {
        return vehiculeRepository.save(vehicule);
    }

    @Override
    public void delete(int id) {
        Vehicule vehicule = vehiculeRepository.findById(id).get();
        if(vehicule!=null){
            vehiculeRepository.delete(vehicule);
        }

    }

    @Override
    public Vehicule update(Vehicule vehicule) {
        return null;
    }

    @Override
    public Vehicule findById(Integer id) {
        Optional<Vehicule> vehicule1 = vehiculeRepository.findById(id);
        return vehicule1.isPresent()? vehicule1.get(): null;
    }

    public int countDeuxRoue(){
        return  vehiculeRepository.countNombreDeRoue2();
    }

    public int countv(){
        return  vehiculeRepository.countIdVehicule();
    }


    public  int countVehicule(){
        return vehiculeRepository.countNombreDeRoueVehicule();
    }
    public int prixTotal(){
        return vehiculeRepository.countPrix();
    }
    public int countQuatreRoue(){
        return vehiculeRepository.countNombreDeRoue4();
    }
    @Override
    public List<Vehicule> list() {
        return vehiculeRepository.findAll();
    }
}
