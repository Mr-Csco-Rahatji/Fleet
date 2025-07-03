package com.example.Fleet.controller;


import com.example.Fleet.config.JwtUtil;
import com.example.Fleet.model.Driver;
import com.example.Fleet.model.Manager;
import com.example.Fleet.repository.ManagerRepository;
import com.example.Fleet.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/drivers")
public class DriverController {

    @Autowired
    private DriverService driverService;

    private final ManagerRepository managerRepository;

    public DriverController(ManagerRepository managerRepository) {
        this.managerRepository = managerRepository;
    }

    @GetMapping
    public ResponseEntity<List<Driver>> getAllDriversForManager() {
        String email = JwtUtil.getCurrentUserEmail();
        Manager manager = managerRepository.findByEmail(email).orElseThrow();
        List<Driver> drivers = driverService.findAllByManagerId(manager.getId());
        return ResponseEntity.ok(drivers);
    }

    @GetMapping("/api/drivers/{id}")
    public ResponseEntity<Driver> getDriverById(@PathVariable UUID id) {
        String email = JwtUtil.getCurrentUserEmail();
        Manager manager = managerRepository.findByEmail(email).orElseThrow();
        Driver driver = driverService.getDriverById(id);
        return ResponseEntity.ok(driver);
    }

    @PostMapping
    public ResponseEntity<Driver> createDriver(@RequestBody Driver driver) {
        String email = JwtUtil.getCurrentUserEmail();
        Manager manager = managerRepository.findByEmail(email).orElseThrow();
        driver.setManager(manager);
        Driver savedDriver = driverService.createDriver(driver);
        return ResponseEntity.ok(savedDriver);
    }

    @PutMapping("/api/drivers/{id}")
    public ResponseEntity<Driver> updateDriver(@PathVariable UUID id, @RequestBody Driver updatedDriver) {
        String email = JwtUtil.getCurrentUserEmail();
        Manager manager = managerRepository.findByEmail(email).orElseThrow();
        Driver driver = driverService.getDriverById(id);

        driver.setName(updatedDriver.getName());
        driver.setSurname(updatedDriver.getSurname());
        driver.setLicenseCode(updatedDriver.getLicenseCode());
        driver.setDateOfBirth(updatedDriver.getDateOfBirth());
        driver.setLicenseExpiryDate(updatedDriver.getLicenseExpiryDate());
        driver.setLicenseFirstIssueDate(updatedDriver.getLicenseFirstIssueDate());
        driver.setAddress(updatedDriver.getAddress());

        return ResponseEntity.ok(driverService.updateDriver(driver.getId(),driver));
    }

    @DeleteMapping("/api/drivers/{id}")
    public ResponseEntity<Void> deleteDriver(@PathVariable UUID id) {
        String email = JwtUtil.getCurrentUserEmail();
        Manager manager = managerRepository.findByEmail(email).orElseThrow();
        Driver driver = driverService.getDriverById(id);
        driverService.deleteDriver(driver.getId());
        return ResponseEntity.noContent().build();
    }
}
