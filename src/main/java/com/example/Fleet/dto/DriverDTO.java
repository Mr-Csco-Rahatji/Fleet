package com.example.Fleet.dto;

import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

public class DriverDTO {
    //remember to change to correct visibility, this is only for testing
    public String name;
    public String surname;
    public String licenseCode;
    public Date dateOfBirth;
    public Date licenseExpiryDate;
    public Date licenseFirstIssueDate;
    public AddressDTO address;

    public DriverDTO(String name, String surname, String licenseCode, Date dateOfBirth, Date licenseExpiryDate, Date licenseFirstIssueDate, AddressDTO address) {
        this.name = name;
        this.surname = surname;
        this.licenseCode = licenseCode;
        this.dateOfBirth = dateOfBirth;
        this.licenseExpiryDate = licenseExpiryDate;
        this.licenseFirstIssueDate = licenseFirstIssueDate;
        this.address = address;
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

    public AddressDTO getAddress() {
        return address;
    }

    public void setAddress(AddressDTO address) {
        this.address = address;
    }
}