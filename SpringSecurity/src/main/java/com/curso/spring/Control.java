package com.curso.spring;

import org.springframework.stereotype.Service;

@Service
public class Control implements IControl {

	@Override
	public void ejecuta() {
		System.out.println("Ejecutando ejecuta");

	}

	@Override
	public void valida() {
		System.out.println("Ejecutando valida");


	}

}
