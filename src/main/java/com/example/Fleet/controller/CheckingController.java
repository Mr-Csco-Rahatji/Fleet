package com.example.Fleet.controller;


import com.example.Fleet.model.Checking;
import com.example.Fleet.service.CheckingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/checkings")
public class CheckingController {

    @Autowired
    private CheckingService checkingService;

    @PostMapping("/taxi/{taxiId}")
    public Checking addChecking(@PathVariable UUID taxiId, @RequestBody Checking checking) {
        return checkingService.addCheckingToTaxi(taxiId, checking);
    }
}
