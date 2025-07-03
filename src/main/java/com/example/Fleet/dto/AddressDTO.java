package com.example.Fleet.dto;

public class AddressDTO {
    public String houseNumber;
    public String streetName;
    public String town;
    public String city;
    public String zipCode;

    public AddressDTO(String houseNumber, String streetName, String town, String city, String zipCode) {
        this.houseNumber = houseNumber;
        this.streetName = streetName;
        this.town = town;
        this.city = city;
        this.zipCode = zipCode;
    }
}