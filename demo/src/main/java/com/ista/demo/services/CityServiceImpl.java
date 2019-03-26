package com.ista.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ista.demo.model.City;
import com.ista.demo.repositories.CityRepository;

@Service
public class CityServiceImpl implements CityService {
	@Autowired
	private CityRepository dao;
	
	/* (non-Javadoc)
	 * @see com.ista.demo.services.CityService#getAll()
	 */
	@Override
	public List<City> getAll() {
		return dao.findAll();
	}
	/* (non-Javadoc)
	 * @see com.ista.demo.services.CityService#getOne(long)
	 */
	@Override
	public Optional<City> getOne(long id) {
		return dao.findById(id);
	}
	/* (non-Javadoc)
	 * @see com.ista.demo.services.CityService#add(com.ista.demo.model.City)
	 */
	@Override
	public void add(City item) throws Exception {
		if(getOne(item.getCityId()).isPresent())
			throw new Exception("Clave duplicada");
		dao.save(item);
	}
	/* (non-Javadoc)
	 * @see com.ista.demo.services.CityService#modify(com.ista.demo.model.City)
	 */
	@Override
	public void modify(City item) throws Exception {
		if(!getOne(item.getCityId()).isPresent())
			throw new Exception("No existe");
		dao.save(item);
	}
	/* (non-Javadoc)
	 * @see com.ista.demo.services.CityService#delete(long)
	 */
	@Override
	public void delete(long id) throws Exception {
		if(!getOne(id).isPresent())
			return;
		dao.deleteById(id);
	}
	/* (non-Javadoc)
	 * @see com.ista.demo.services.CityService#delete(com.ista.demo.model.City)
	 */
	@Override
	public void delete(City item) throws Exception {
		delete(item.getCityId());
	}
}
