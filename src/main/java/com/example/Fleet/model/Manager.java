package com.example.Fleet.model;

import jakarta.persistence.*;
import java.util.UUID;
import java.util.List;

@Entity
public class Manager {

    @Id
    private UUID id = UUID.randomUUID();

    private String name;
    private String surname;

    @Column(unique = true)
    private String email;
    private String password;

    @OneToMany(mappedBy = "manager", cascade = CascadeType.ALL)
    private List<Driver> drivers;

    @OneToMany(mappedBy = "manager", cascade = CascadeType.ALL)
    private List<Taxi> taxis;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Driver> getDrivers() {
        return drivers;
    }

    public void setDrivers(List<Driver> drivers) {
        this.drivers = drivers;
    }

    public List<Taxi> getTaxis() {
        return taxis;
    }

    public void setTaxis(List<Taxi> taxis) {
        this.taxis = taxis;
    }
}