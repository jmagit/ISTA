package com.ista.demo.ioc;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Scope("prototype") 
@Data
public class PuntoImpl implements Punto {
	private int x = 1, y = 2;

}
