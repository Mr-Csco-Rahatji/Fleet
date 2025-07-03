package com.example.Fleet.controller;


import com.example.Fleet.config.JwtUtil;
import com.example.Fleet.model.Manager;
import com.example.Fleet.model.Taxi;
import com.example.Fleet.repository.ManagerRepository;
import com.example.Fleet.service.TaxiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/taxis")
public class TaxiController {

    @Autowired
    private TaxiService taxiService;

    private final ManagerRepository managerRepository;

    public TaxiController(ManagerRepository managerRepository) {
        this.managerRepository = managerRepository;
    }

    @GetMapping("/api/taxis")
    public ResponseEntity<List<Taxi>> getAllTaxisForManager() {
        String email = JwtUtil.getCurrentUserEmail();
        Manager manager = managerRepository.findByEmail(email).orElseThrow();
        List<Taxi> taxis = taxiService.getAllByManagerId(manager.getId());
        return ResponseEntity.ok(taxis);
    }

    @GetMapping("/api/taxis/{id}")
    public ResponseEntity<Taxi> getTaxiById(@PathVariable UUID id) {
        String email = JwtUtil.getCurrentUserEmail();
        Manager manager = managerRepository.findByEmail(email).orElseThrow();
        Taxi taxi = taxiService.getTaxiById(id);
        return ResponseEntity.ok(taxi);
    }

    @PostMapping
    public ResponseEntity<Taxi> createTaxi(@RequestBody Taxi taxi) {
        String email = JwtUtil.getCurrentUserEmail();
        Manager manager = managerRepository.findByEmail(email).orElseThrow();
        taxi.setManager(manager);
        Taxi savedTaxi = taxiService.createTaxi(taxi);
        return ResponseEntity.ok(savedTaxi);
    }

    @PutMapping("/api/taxis/{id}")
    public ResponseEntity<Taxi> updateTaxi(@PathVariable UUID id, @RequestBody Taxi updatedTaxi) {
        String email = JwtUtil.getCurrentUserEmail();
        Manager manager = managerRepository.findByEmail(email).orElseThrow();
        Taxi taxi = taxiService.getTaxiById(id);

        taxi.setMake(updatedTaxi.getMake());
        taxi.setModel(updatedTaxi.getModel());
        taxi.setYear(updatedTaxi.getYear());
        taxi.setRegistrationNumber(updatedTaxi.getRegistrationNumber());
        taxi.setVinNumber(updatedTaxi.getVinNumber());
        taxi.setNumberOfPassengers(updatedTaxi.getNumberOfPassengers());
        taxi.setColour(updatedTaxi.getColour());

        return ResponseEntity.ok(taxiService.createTaxi(taxi));
    }

    @DeleteMapping("/api/taxis/{id}")
    public ResponseEntity<Void> deleteTaxi(@PathVariable UUID id) {
        String email = JwtUtil.getCurrentUserEmail();
        Manager manager = managerRepository.findByEmail(email).orElseThrow();
        Taxi taxi = taxiService.getTaxiById(id);
        taxiService.deleteTaxi(taxi.getId());
        return ResponseEntity.noContent().build();
    }
}