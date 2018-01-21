package com.curso.spring;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	@Autowired
	public Control control;
	

	@Secured("ROLE_USER")
	@RequestMapping(value = "seguridad.do")
	public String home(Locale locale, Model model) {
		System.out.println("Welcome home! The client locale is {}."+ locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		ejecutaMetodos();
		
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	public void ejecutaMetodos(){
		System.out.println("Va a ejecutar");
		control.ejecuta();
		System.out.println("Va a validar");
		control.valida();
	}
	
}
