package com.curso;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StudentController {

   @RequestMapping(value = "/student", method = RequestMethod.GET)
   public ModelAndView student(ModelMap model) {
		
	  System.out.println("Creando objeto student vacio y enviandolo al formulario");
	  //model.addAttribute("myStudent", new Student("Juan"));
	  //return new ModelAndView("student");//Genera error
	  return new ModelAndView("student", "myStudent", new Student("Juan"));
   }
   
//   @RequestMapping(value = "/student", method = RequestMethod.GET)
//   public String student() {
//	   System.out.println("Creando objeto student vacio y enviandolo al formulario");
//      return "student";
//   }
   
   @RequestMapping(value = "/addStudent", method = RequestMethod.POST) 
   public String addStudent(@ModelAttribute("myStudent")Student student, ModelMap model) {
	  System.out.println("Recibido objeto Student");
      model.addAttribute("name", student.getName());
      model.addAttribute("age", student.getAge());
      model.addAttribute("id", student.getId());
      model.addAttribute("apellidos", student.getApellidos());

      return "result";
   }
}