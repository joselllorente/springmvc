package com.curso;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@RequestMapping("/customer.htm")
@SessionAttributes("customer")
public class CustomerController{
	@Autowired
	CustomerValidator customerValidator;
	
	
	public CustomerController() {
		super();
	}

	@Autowired
	public CustomerController(CustomerValidator customerValidator){
		this.customerValidator = customerValidator;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String processSubmit(@ModelAttribute("customer") Customer customer,	BindingResult result, Model model, SessionStatus status, HttpSession session) {
		System.out.println(session.getAttribute("customer").toString());
		customerValidator.validate(customer, result);
		
		if (result.hasErrors()) {
			//if validator failed
			return "CustomerForm";
		} else {
			status.setComplete();
			//form success
			return "CustomerSuccess";
		}
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String initForm(ModelMap model){
		
		Customer cust = new Customer();
		//Make "Spring MVC" as default checked value
		cust.setFavFramework(new String []{"Spring MVC"});
		
		//Make "Make" as default radio button selected value
		cust.setSex("M");
		
		//make "Hibernate" as the default java skills selection
		cust.setJavaSkills("Hibernate");
		
		//initilize a hidden value
		cust.setSecretValue("I'm hidden value");
		
		cust.setDate(new Date());
		
		//command object
		model.addAttribute("customer", cust);
		
		//return form view
		return "CustomerForm";
	}
	
	
	@ModelAttribute("webFrameworkList")
	public List<String> populateWebFrameworkList() {
	//public void populateWebFrameworkList(ModelMap model) {
		
		//Data referencing for web framework checkboxes
		List<String> webFrameworkList = new ArrayList<String>();
		webFrameworkList.add("Spring MVC");
		webFrameworkList.add("Struts 1");
		webFrameworkList.add("Struts 2");
		webFrameworkList.add("JSF");
		webFrameworkList.add("Apache Wicket");
		
		//model.addAttribute("webFrameworkList", webFrameworkList);
		return webFrameworkList;
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
		
	}
	
	@ModelAttribute("numberList")
	public List<String> populateNumberList() {
		
		//Data referencing for number radiobuttons
		List<String> numberList = new ArrayList<String>();
		numberList.add("Number 1");
		numberList.add("Number 2");
		numberList.add("Number 3");
		numberList.add("Number 4");
		numberList.add("Number 5");
		
		return numberList;
	}
	
	@ModelAttribute("javaSkillsList")
	public Map<String,String> populateJavaSkillList() {
		
		//Data referencing for java skills list box
		Map<String,String> javaSkill = new LinkedHashMap<String,String>();
		javaSkill.put("Hibernate", "Hibernate");
		javaSkill.put("Spring", "Spring");
		javaSkill.put("Apache Wicket", "Apache Wicket");
		javaSkill.put("Struts", "Struts");
		
		return javaSkill;
	}

	@ModelAttribute("countryList")
	public Map<String,String> populateCountryList() {
		
		//Data referencing for java skills list box
		Map<String,String> country = new LinkedHashMap<String,String>();
		country.put("US", "United Stated");
		country.put("CHINA", "China");
		country.put("SG", "Singapore");
		country.put("MY", "Malaysia");
		
		return country;
	}
	
}