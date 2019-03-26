package com.ista.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ista.demo.ioc.Linea;
import com.ista.demo.ioc.Punto;

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

	
	@Override
	public void run(String... args) throws Exception {
//		System.out.println("HOLA MUNDOooooo");
//		System.out.println(punto.toString());
//		punto.setX(11);
//		System.out.println(punto2.toString());
//		System.out.println(name);
		
	}

}
