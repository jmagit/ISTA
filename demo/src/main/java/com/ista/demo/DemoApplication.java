package com.ista.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ista.demo.ioc.Punto;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Autowired
	private Punto punto;
	@Autowired
	private Punto punto2;
	
	@Override
	public void run(String... args) throws Exception {
		System.out.println("HOLA MUNDOooooo");
		System.out.println(punto.toString());
		punto.setX(11);
		System.out.println(punto2.toString());
		
	}

}
