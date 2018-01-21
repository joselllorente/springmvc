package com.curso.spring;

import org.springframework.security.access.prepost.PreAuthorize;

public interface IControl {
	
	public void ejecuta ();
	
	public void valida();
}
