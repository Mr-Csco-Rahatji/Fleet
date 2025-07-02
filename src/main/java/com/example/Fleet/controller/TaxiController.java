package com.example.Fleet.controller;


import com.example.Fleet.model.Taxi;
import com.example.Fleet.service.TaxiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/taxis")
public class TaxiController {

    @Autowired
    private TaxiService taxiService;

    @PostMapping
    public Taxi createTaxi(@RequestBody Taxi taxi) {
        return taxiService.createTaxi(taxi);
    }

    @GetMapping
    public List<Taxi> getAllTaxis() {
        return taxiService.getAllTaxis();
    }

    @GetMapping("/{id}")
    public Taxi getTaxiById(@PathVariable UUID id) {
        return taxiService.getTaxiById(id);
    }

    @PutMapping("/{id}")
    public Taxi updateTaxi(@PathVariable UUID id, @RequestBody Taxi taxi) {
        return taxiService.updateTaxi(id, taxi);
    }

    @DeleteMapping("/{id}")
    public void deleteTaxi(@PathVariable UUID id) {
        taxiService.deleteTaxi(id);
    }
}