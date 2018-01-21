package com.curso;

import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class CustomerValidator implements Validator{

	
	public CustomerValidator() {
		System.out.println("CustomerValidator()");
	}

	@Override
	public boolean supports(Class clazz) {
		//just validate the Customer instances
		return Customer.class.isAssignableFrom(clazz);
		//instanceof can only be used with reference types, not primitive types.  isAssignableFrom() can be used with any class objects:
		//  a instanceof int  // syntax error
		//	3 instanceof Foo  // syntax error
		//  int.class.isAssignableFrom(int.class)  // true
	}

	@Override
	public void validate(Object target, Errors errors) {
		if(errors.hasErrors()){
			FieldError field=errors.getFieldError();
			if(field.getField().equals("date")){
				System.out.println(field.getCode());
				System.out.println(field.getDefaultMessage());
				System.out.println(field.getObjectName());
			}
		}
		//El m�todo rejectIfEmptyOrWhitespace de la clase ValidationUtils 
		//es el encargado de a��adir el error y realizar la validacion
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName",
				"required.userName", "Field name is required.");
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address",
				"required.address", "Field name is required.");
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password",
				"required.password", "Field name is required.");
			
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "confirmPassword",
				"required.confirmPassword", "Field name is required.");
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "sex", 
				"required.sex", "Field name is required.");
		
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "favNumber", 
//				"required.favNumber", "Field name is required.");
		
		ValidationUtils.rejectIfEmptyOrWhitespace(
				errors, "javaSkills", "required.javaSkills","Field name is required.");
		
		Customer cust = (Customer)target;
		
		if(!(cust.getPassword().equals(cust.getConfirmPassword()))){
			errors.rejectValue("password", "notmatch.password");
		}
		
		if(cust.getFavFramework().length==0){
			errors.rejectValue("favFramework", "required.favFrameworks");
		}

		if("NONE".equals(cust.getCountry())){
			errors.rejectValue("country", "required.country");
		}
		
	}
	
}