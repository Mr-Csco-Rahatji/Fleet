package com.example.Fleet.repository;

import com.example.Fleet.model.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface DriverRepository extends JpaRepository<Driver, UUID> {
    List<Driver> findByManagerId(UUID id);
}