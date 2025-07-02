package com.example.Fleet.service;


import com.example.Fleet.model.Driver;
import com.example.Fleet.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class DriverService {

    @Autowired
    private DriverRepository driverRepository;

    public Driver createDriver(Driver driver) {
        return driverRepository.save(driver);
    }

    public List<Driver> getAllDrivers() {
        return driverRepository.findAll();
    }

    public Driver getDriverById(UUID id) {
        return driverRepository.findById(id).orElseThrow();
    }

    public Driver updateDriver(UUID id, Driver updated) {
        Driver driver = getDriverById(id);
        driver.setName(updated.getName());
        driver.setSurname(updated.getSurname());
        driver.setLicenseCode(updated.getLicenseCode());
        driver.setDateOfBirth(updated.getDateOfBirth());
        driver.setLicenseExpiryDate(updated.getLicenseExpiryDate());
        driver.setLicenseFirstIssueDate(updated.getLicenseFirstIssueDate());
        driver.setAddress(updated.getAddress());
        return driverRepository.save(driver);
    }

    public void deleteDriver(UUID id) {
        driverRepository.deleteById(id);
    }
}
