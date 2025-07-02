package com.example.Fleet.service;

import com.example.Fleet.model.Taxi;
import com.example.Fleet.repository.TaxiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
