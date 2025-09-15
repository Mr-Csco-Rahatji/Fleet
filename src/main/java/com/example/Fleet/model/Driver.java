package com.example.Fleet.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

@Entity
public class Driver {

    @Id
    private UUID id = UUID.randomUUID();

    private String name;
    private String surname;
    private String licenseCode;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date dateOfBirth;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date licenseExpiryDate;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date licenseFirstIssueDate;

    @OneToOne(cascade = CascadeType.ALL)
    private Address address;

    @ManyToOne
    private Manager manager;

    @OneToOne(mappedBy = "driver")
    private Taxi taxi;

    public Driver(){

    }
    public Driver(UUID id, String name, String surname, String licenseCode, Date dateOfBirth, Date licenseExpiryDate, Date licenseFirstIssueDate, Address address, Manager manager, Taxi taxi) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.licenseCode = licenseCode;
        this.dateOfBirth = dateOfBirth;
        this.licenseExpiryDate = licenseExpiryDate;
        this.licenseFirstIssueDate = licenseFirstIssueDate;
        this.address = address;
        this.manager = manager;
        this.taxi = taxi;
    }

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

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Date getLicenseExpiryDate() {
        return licenseExpiryDate;
    }

    public void setLicenseExpiryDate(Date licenseExpiryDate) {
        this.licenseExpiryDate = licenseExpiryDate;
    }

    public Date getLicenseFirstIssueDate() {
        return licenseFirstIssueDate;
    }

    public void setLicenseFirstIssueDate(Date licenseFirstIssueDate) {
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