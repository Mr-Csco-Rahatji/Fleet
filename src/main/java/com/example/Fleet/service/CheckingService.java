package com.example.Fleet.service;


import com.example.Fleet.model.Checking;
import com.example.Fleet.model.Taxi;
import com.example.Fleet.repository.CheckingRepository;
import com.example.Fleet.repository.TaxiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CheckingService {

    @Autowired
    private CheckingRepository checkingRepository;

    @Autowired
    private TaxiRepository taxiRepository;

    public Checking addCheckingToTaxi(UUID taxiId, Checking checking) {
        Taxi taxi = taxiRepository.findById(taxiId).orElseThrow();
        checking.setTaxi(taxi);
        return checkingRepository.save(checking);
    }
}