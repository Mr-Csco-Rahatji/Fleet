package com.example.Fleet.model;

import jakarta.persistence.*;
import java.util.UUID;
import java.util.List;

@Entity
public class Taxi {

    @Id
    private UUID id = UUID.randomUUID();

    private String make;
    private String model;
    private int year;
    private String registrationNumber;
    private String vinNumber;
    private int numberOfPassengers;
    private String colour;

    @ManyToOne
    private Manager manager;

    @OneToOne
    private Driver driver;

    @OneToMany(mappedBy = "taxi", cascade = CascadeType.ALL)
    private List<Checking> checkings;

    // Getters and setters

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getVinNumber() {
        return vinNumber;
    }

    public void setVinNumber(String vinNumber) {
        this.vinNumber = vinNumber;
    }

    public int getNumberOfPassengers() {
        return numberOfPassengers;
    }

    public void setNumberOfPassengers(int numberOfPassengers) {
        this.numberOfPassengers = numberOfPassengers;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public List<Checking> getCheckings() {
        return checkings;
    }

    public void setCheckings(List<Checking> checkings) {
        this.checkings = checkings;
    }
}
