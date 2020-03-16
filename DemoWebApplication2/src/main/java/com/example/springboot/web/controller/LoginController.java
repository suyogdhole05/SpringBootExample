package com.example.springboot.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import com.example.springboot.web.service.LoginService;

@Controller
@SessionAttributes("name")
public class LoginController {
	
	@Autowired
	LoginService service;
	
	@RequestMapping("/dummyLogin")
	public String sayHello(@RequestParam("name") String name,ModelMap model) {
		model.put("name", name);
		return "login";
	}
	
	@RequestMapping("/go")
	@ResponseBody
	public String sayBye(@RequestParam(value="id", defaultValue="Suyog", required=false)String id) {
		
		return "Hello Spring Boot  "+id;
	}
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String sendWelcomePage(ModelMap model) {
		model.put("name", "suyog");
		return "welcome";
	}
	
	/*@RequestMapping(value="/loginForm",method=RequestMethod.GET)
	public String sendLoginPage() {		
		return "loginForm";
	}

	@RequestMapping(value="/loginForm",method=RequestMethod.POST)
	public String handleLogin(ModelMap model,@RequestParam String name,String password) {	
		boolean isValidate = service.validateLogin(name, password);
		if(!isValidate) {
			model.put("errorMessage", "Invalid Credentials");
			return "loginForm";
		}
			
		
		model.put("name", name);
		model.put("pwd", password);
		
		return "welcome";
	}*/

}
