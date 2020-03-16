package com.example.springboot.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/home")
public class HomeController {
	
	@RequestMapping(value= {
			"",
			"/",
			"/page",
			"/page*",
			"/suyog"
	})
	@ResponseBody
	public String goHome() {
		
		return "Go Home";
	}
	
	@RequestMapping(value="/address",method=RequestMethod.POST)
	@ResponseBody
	public String sendAddress() {
		
		return "Hadapsar, Pune Post!!!!";
	}
	
	@RequestMapping(value="/address",method=RequestMethod.GET)
	@ResponseBody
	public String chkAddress() {
		
		return "Hadapsar, Pune GET";
	}

}
