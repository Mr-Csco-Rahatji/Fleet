package com.example.Fleet.controller;


import com.example.Fleet.config.JwtUtil;
import com.example.Fleet.dto.DriverDTO;
import com.example.Fleet.model.Address;
import com.example.Fleet.model.Driver;
import com.example.Fleet.model.Manager;
import com.example.Fleet.repository.ManagerRepository;
import com.example.Fleet.service.AddressService;
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
    @Autowired
    private AddressService addressService;

    private final ManagerRepository managerRepository;

    public DriverController(ManagerRepository managerRepository) {
        this.managerRepository = managerRepository;
    }

    @GetMapping
    public ResponseEntity<List<DriverDTO>> getAllDriversForManager() {
        String email = JwtUtil.getCurrentUserEmail();
        Manager manager = managerRepository.findByEmail(email).orElseThrow();
        List<Driver> drivers = driverService.findAllByManagerId(manager.getId());
        return ResponseEntity.ok(driverService.changeToDTOS(drivers));
    }

    @GetMapping("/api/drivers/{id}")
    public ResponseEntity<Driver> getDriverById(@PathVariable UUID id) {
        String email = JwtUtil.getCurrentUserEmail();
        Manager manager = managerRepository.findByEmail(email).orElseThrow();
        Driver driver = driverService.getDriverById(id);
        return ResponseEntity.ok(driver);
    }

    @PostMapping
    public ResponseEntity<DriverDTO> createDriver(@RequestBody DriverDTO driverDto) {
        String email = JwtUtil.getCurrentUserEmail();
        Manager manager = managerRepository.findByEmail(email).orElseThrow();
        Driver driver = new Driver();
        driver.setName(driverDto.name);
        driver.setSurname(driverDto.surname);
        driver.setLicenseCode(driverDto.licenseCode);
        driver.setDateOfBirth(driverDto.dateOfBirth);
        driver.setLicenseExpiryDate(driverDto.licenseExpiryDate);
        driver.setLicenseFirstIssueDate(driverDto.licenseFirstIssueDate);
        Address address = new Address();
        address.setHouseNumber(driverDto.address.houseNumber);
        address.setStreetName(driverDto.address.streetName);
        address.setTown(driverDto.address.town);
        address.setCity(driverDto.address.city);
        address.setZipCode(driverDto.address.zipCode);
        driver.setAddress(address);
        driver.setManager(manager);
        Driver savedDriver = driverService.createDriver(driver);
        return ResponseEntity.ok(driverService.changeToDTO(savedDriver));
    }

    @PutMapping("/api/drivers/{id}")
    public ResponseEntity<Driver> updateDriver(@PathVariable UUID id, @RequestBody DriverDTO driverDto) {
        String email = JwtUtil.getCurrentUserEmail();
        Manager manager = managerRepository.findByEmail(email).orElseThrow();
        Driver driver = driverService.getDriverById(id);

        driver.setName(driverDto.getName());
        driver.setSurname(driverDto.getSurname());
        driver.setLicenseCode(driverDto.getLicenseCode());
        driver.setDateOfBirth(driverDto.getDateOfBirth());
        driver.setLicenseExpiryDate(driverDto.getLicenseExpiryDate());
        driver.setLicenseFirstIssueDate(driverDto.getLicenseFirstIssueDate());
        Address address = new Address();
        address.setHouseNumber(driverDto.getAddress().houseNumber);
        address.setStreetName(driverDto.getAddress().streetName);
        address.setTown(driverDto.getAddress().town);
        address.setCity(driverDto.getAddress().city);
        address.setZipCode(driverDto.getAddress().zipCode);
        driver.setAddress(address);

        return ResponseEntity.ok(driverService.createDriver(driver));
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
