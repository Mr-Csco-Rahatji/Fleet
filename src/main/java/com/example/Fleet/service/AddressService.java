package com.example.Fleet.service;

import com.example.Fleet.dto.AddressDTO;
import com.example.Fleet.model.Address;
import com.example.Fleet.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    public Address changeToEntity(AddressDTO addressDTO){
        return new Address(UUID.randomUUID(),addressDTO.houseNumber,addressDTO.streetName,addressDTO.town,addressDTO.city,addressDTO.zipCode);
    }

    public AddressDTO changeToDTO(Address address){
        return new AddressDTO(address.getHouseNumber(),address.getStreetName(),address.getTown(),address.getCity(),address.getZipCode());
    }
}
