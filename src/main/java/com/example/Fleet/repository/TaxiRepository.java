package com.example.Fleet.repository;

import com.example.Fleet.model.Driver;
import com.example.Fleet.model.Taxi;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface TaxiRepository extends JpaRepository<Taxi, UUID> {
    List<Taxi> findByManagerId(UUID id);
}