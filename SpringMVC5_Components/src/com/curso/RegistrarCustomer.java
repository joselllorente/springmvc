package com.curso;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("singleton") 
public class RegistrarCustomer {

	public RegistrarCustomer() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public void registraCustomer (Customer cust){
		System.out.println("Registrando Customer " + cust);
	}
}
