package com.example.Fleet.controller;


import com.example.Fleet.config.JwtUtil;
import com.example.Fleet.dto.TaxiDTO;
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

    @GetMapping
    public ResponseEntity<List<TaxiDTO>> getAllTaxisForManager() {
        String email = JwtUtil.getCurrentUserEmail();
        Manager manager = managerRepository.findByEmail(email).orElseThrow();
        List<Taxi> taxis = taxiService.getAllByManagerId(manager.getId());
        return ResponseEntity.ok(taxiService.changeToDTOs(taxis));
    }

    @GetMapping("/api/taxis/{id}")
    public ResponseEntity<TaxiDTO> getTaxiById(@PathVariable UUID id) {
        String email = JwtUtil.getCurrentUserEmail();
        Manager manager = managerRepository.findByEmail(email).orElseThrow();
        Taxi taxi = taxiService.getTaxiById(id);
        return ResponseEntity.ok(taxiService.changeToDto(taxi));
    }

    @PostMapping
    public ResponseEntity<TaxiDTO> createTaxi(@RequestBody TaxiDTO taxiDto) {
        String email = JwtUtil.getCurrentUserEmail();
        Manager manager = managerRepository.findByEmail(email).orElseThrow();
        Taxi taxi = new Taxi();
        taxi.setMake(taxiDto.make);
        taxi.setModel(taxiDto.model);
        taxi.setYear(taxiDto.year);
        taxi.setRegistrationNumber(taxiDto.registrationNumber);
        taxi.setVinNumber(taxiDto.vinNumber);
        taxi.setNumberOfPassengers(taxiDto.numberOfPassengers);
        taxi.setColour(taxiDto.colour);
        taxi.setManager(manager);
        Taxi savedTaxi = taxiService.createTaxi(taxi);
        return ResponseEntity.ok(taxiService.changeToDto(savedTaxi));
    }

    @PutMapping("/api/taxis/{id}")
    public ResponseEntity<TaxiDTO> updateTaxi(@PathVariable UUID id, @RequestBody TaxiDTO taxiDto) {
        String email = JwtUtil.getCurrentUserEmail();
        Manager manager = managerRepository.findByEmail(email).orElseThrow();
        Taxi taxi = taxiService.getTaxiById(id);

        taxi.setMake(taxiDto.make);
        taxi.setModel(taxiDto.model);
        taxi.setYear(taxiDto.year);
        taxi.setRegistrationNumber(taxiDto.registrationNumber);
        taxi.setVinNumber(taxiDto.vinNumber);
        taxi.setNumberOfPassengers(taxiDto.numberOfPassengers);
        taxi.setColour(taxiDto.colour);

        return ResponseEntity.ok(taxiService.changeToDto(taxiService.updateTaxi(taxi.getId(),taxi)));
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