package com.example.Fleet.service;

import com.example.Fleet.dto.TaxiDTO;
import com.example.Fleet.model.Taxi;
import com.example.Fleet.repository.TaxiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class TaxiService {

    @Autowired
    private TaxiRepository taxiRepository;

    public Taxi createTaxi(Taxi taxi) {
        return taxiRepository.save(taxi);
    }

    public List<Taxi> getAllTaxis() {
        return taxiRepository.findAll();
    }

    public List<Taxi> getAllByManagerId(UUID id) {
        return taxiRepository.findByManagerId(id);
    }

    public Taxi getTaxiById(UUID id) {
        return taxiRepository.findById(id).orElseThrow();
    }

    public Taxi updateTaxi(UUID id, Taxi updated) {
        Taxi taxi = getTaxiById(id);

        taxi.setMake(updated.getMake());
        taxi.setModel(updated.getModel());
        taxi.setYear(updated.getYear());
        taxi.setRegistrationNumber(updated.getRegistrationNumber());
        taxi.setVinNumber(updated.getVinNumber());
        taxi.setNumberOfPassengers(updated.getNumberOfPassengers());
        taxi.setColour(updated.getColour());

        return taxiRepository.save(taxi);
    }

    public void deleteTaxi(UUID id) {
        taxiRepository.deleteById(id);
    }

    public Taxi changeToEntity(TaxiDTO taxiDTO){
        Taxi taxi=new Taxi();
        taxi.setColour(taxiDTO.colour);
        taxi.setMake(taxiDTO.make);
        taxi.setModel(taxiDTO.model);
        taxi.setNumberOfPassengers(taxiDTO.numberOfPassengers);
        taxi.setId(taxiDTO.id);
        taxi.setYear(taxiDTO.year);
        taxi.setRegistrationNumber(taxiDTO.registrationNumber);
        taxi.setVinNumber(taxiDTO.vinNumber);
        return taxi;
    }

    public TaxiDTO changeToDto(Taxi taxi){
        TaxiDTO taxiDTO=new TaxiDTO();
        taxiDTO.id=taxi.getId();
        taxiDTO.colour=taxi.getColour();
        taxiDTO.make=taxi.getMake();
        taxiDTO.model=taxi.getModel();
        taxiDTO.vinNumber=taxi.getVinNumber();
        taxiDTO.numberOfPassengers=taxi.getNumberOfPassengers();
        taxiDTO.registrationNumber=taxi.getRegistrationNumber();
        taxiDTO.year=taxi.getYear();
        return taxiDTO;
    }

    public List<Taxi> changeToEntities(List<TaxiDTO> taxiDTOS){
        List<Taxi> taxis=new ArrayList<>();
        for(int a=0;a<taxiDTOS.size();a++){
            taxis.add(changeToEntity(taxiDTOS.get(a)));
        }
        return taxis;
    }

    public List<TaxiDTO> changeToDTOs(List<Taxi> taxis){
        List<TaxiDTO> taxiDTOS=new ArrayList<>();
        for(int a=0;a<taxis.size();a++){
            taxiDTOS.add(changeToDto(taxis.get(a)));
        }
        return taxiDTOS;
    }
}
