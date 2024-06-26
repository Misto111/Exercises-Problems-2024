package org.example.modelmapper.repositories;

import org.example.modelmapper.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
        Optional<Address> findByCountryAndCity(String country, String city);
}
