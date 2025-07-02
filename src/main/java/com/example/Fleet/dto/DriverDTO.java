package com.example.Fleet.dto;

import java.time.LocalDate;
import java.util.UUID;

public class DriverDTO {
    public UUID id;
    public String name;
    public String surname;
    public String licenseCode;
    public LocalDate dateOfBirth;
    public LocalDate licenseExpiryDate;
    public LocalDate licenseFirstIssueDate;
    public AddressDTO address;
}