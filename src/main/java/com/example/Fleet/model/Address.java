package com.example.Fleet.model;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
public class Address {
    @Id
    private UUID id = UUID.randomUUID();

    private String houseNumber;
    private String streetName;
    private String town;
    private String city;
    private String zipCode;

    public Address(){

    }

    public Address(UUID id, String houseNumber, String streetName, String town, String city, String zipCode) {
        this.id = id;
        this.houseNumber = houseNumber;
        this.streetName = streetName;
        this.town = town;
        this.city = city;
        this.zipCode = zipCode;
    }

    // Getters and setters

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
}