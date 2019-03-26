package com.ista.demo.services;

import java.util.List;
import java.util.Optional;

import com.ista.demo.model.City;

public interface CityService {

	List<City> getAll();

	Optional<City> getOne(long id);

	void add(City item) throws Exception;

	void modify(City item) throws Exception;

	void delete(long id) throws Exception;

	void delete(City item) throws Exception;

}