package com.ista.demo;

import java.util.stream.Collectors;

import javax.lang.model.element.Element;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import com.ista.demo.dtos.CityDTO;
import com.ista.demo.ioc.Linea;
import com.ista.demo.ioc.Punto;
import com.ista.demo.model.Address;
import com.ista.demo.model.City;
import com.ista.demo.repositories.CityRepository;

import oracle.net.ns.DataDescriptorPacket;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Autowired
//	@Qualifier("2D")
	private Punto punto;
	@Autowired
//	@Qualifier("3D")
	private Punto punto2;
	
	@Autowired
	Linea linea;
	
	@Value("${spring.datasource.username}") 
	private String name;

	@Autowired
	private CityRepository dao;
	
	@Override
	@Transactional
	public void run(String... args) throws Exception {
//		System.out.println("HOLA MUNDOooooo");
//		System.out.println(punto.toString());
//		punto.setX(11);
//		System.out.println(punto2.toString());
//		System.out.println(name);
//		for (City item : dao.findAll()) {
//			//System.out.println(item.getCity() + " (" + item.getCountry().getCountry() + ")");
//			CityDTO dto = CityDTO.form(item);
//			System.out.println(dto.getCity() + " (" + dto.getCountryId() + ")");
//			
////			for(Address dir: item.getAddresses())
////				System.out.println("\t" + dir.getAddress());
//		}
		for (CityDTO dto : dao.findByCityIdLessThanOrderByCityDesc(44)
				.stream().map(ele -> CityDTO.form(ele)).collect(Collectors.toList())) {
			System.out.println(dto.getCityId() + "-" + dto.getCity() + " (" + dto.getCountryId() + ")");
		}
	}

}
