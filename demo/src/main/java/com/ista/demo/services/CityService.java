package com.ista.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ista.demo.model.City;
import com.ista.demo.repositories.CityRepository;

@Service
public class CityService {
	@Autowired
	private CityRepository dao;
	
	public List<City> getAll() {
		return dao.findAll();
	}
	public Optional<City> getOne(long id) {
		return dao.findById(id);
	}
	public void add(City item) throws Exception {
		if(getOne(item.getCityId()).isPresent())
			throw new Exception("Clave duplicada");
		dao.save(item);
	}
	public void modify(City item) throws Exception {
		if(!getOne(item.getCityId()).isPresent())
			throw new Exception("No existe");
		dao.save(item);
	}
	public void delete(long id) throws Exception {
		if(!getOne(id).isPresent())
			return;
		dao.deleteById(id);
	}
	public void delete(City item) throws Exception {
		delete(item.getCityId());
	}
}
