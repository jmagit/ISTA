package com.ista.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ista.demo.model.City;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {
	List<City> findByCityIdLessThanOrderByCityDesc(long max);
}
