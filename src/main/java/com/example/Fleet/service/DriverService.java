package com.example.Fleet.service;


import com.example.Fleet.dto.DriverDTO;
import com.example.Fleet.model.Address;
import com.example.Fleet.model.Driver;
import com.example.Fleet.model.Manager;
import com.example.Fleet.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class DriverService {

    @Autowired
    private DriverRepository driverRepository;
    @Autowired
    private AddressService addressService;

    public Driver createDriver(Driver driver) {
        return driverRepository.save(driver);
    }

    public List<Driver> getAllDrivers() {
        return driverRepository.findAll();
    }

    public List<Driver> findAllByManagerId(UUID id){
        return driverRepository.findByManagerId(id);
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

    public DriverDTO changeToDTO(Driver driver){
        return new DriverDTO(
                 driver.getName()
                ,driver.getSurname()
                ,driver.getLicenseCode()
                ,driver.getDateOfBirth()
                ,driver.getLicenseExpiryDate()
                ,driver.getLicenseFirstIssueDate()
                ,addressService.changeToDTO(driver.getAddress())
        );
    }

    public Driver changeToEntity(DriverDTO driverDTO){
        return new Driver(
                 UUID.randomUUID()
                 ,driverDTO.name
                ,driverDTO.surname
                ,driverDTO.licenseCode
                ,driverDTO.dateOfBirth
                ,driverDTO.licenseExpiryDate
                ,driverDTO.licenseFirstIssueDate
                ,null
                ,new Manager(),
                null
        );
    }

    public List<Driver> changeToEntities(List<DriverDTO> driverDTOS){
        List<Driver> drivers=new ArrayList<>();
        for (DriverDTO driverDTO : driverDTOS) {
            drivers.add(changeToEntity(driverDTO));
        }
        return drivers;
    }

    public List<DriverDTO> changeToDTOS(List<Driver> drivers){
        List<DriverDTO> driverDTOS=new ArrayList<>();
        for (Driver driver : drivers) {
            driverDTOS.add(changeToDTO(driver));
        }
        return driverDTOS;
    }

    public void deleteDriver(UUID id) {
        driverRepository.deleteById(id);
    }
}
