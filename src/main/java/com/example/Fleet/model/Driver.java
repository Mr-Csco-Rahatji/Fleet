package com.example.Fleet.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
public class Driver {

    @Id
    private UUID id = UUID.randomUUID();

    private String name;
    private String surname;
    private String licenseCode;
    private LocalDate dateOfBirth;
    private LocalDate licenseExpiryDate;
    private LocalDate licenseFirstIssueDate;

    @OneToOne(cascade = CascadeType.ALL)
    private Address address;

    @ManyToOne
    private Manager manager;

    @OneToOne(mappedBy = "driver")
    private Taxi taxi;

    // Getters and setters

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getLicenseCode() {
        return licenseCode;
    }

    public void setLicenseCode(String licenseCode) {
        this.licenseCode = licenseCode;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public LocalDate getLicenseExpiryDate() {
        return licenseExpiryDate;
    }

    public void setLicenseExpiryDate(LocalDate licenseExpiryDate) {
        this.licenseExpiryDate = licenseExpiryDate;
    }

    public LocalDate getLicenseFirstIssueDate() {
        return licenseFirstIssueDate;
    }

    public void setLicenseFirstIssueDate(LocalDate licenseFirstIssueDate) {
        this.licenseFirstIssueDate = licenseFirstIssueDate;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public Taxi getTaxi() {
        return taxi;
    }

    public void setTaxi(Taxi taxi) {
        this.taxi = taxi;
    }
}