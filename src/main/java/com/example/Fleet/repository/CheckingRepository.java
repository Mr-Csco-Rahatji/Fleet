package com.example.Fleet.repository;


import com.example.Fleet.model.Checking;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface CheckingRepository extends JpaRepository<Checking, UUID> {
}