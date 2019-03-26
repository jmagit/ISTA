package com.ista.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ista.demo.model.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {

}
