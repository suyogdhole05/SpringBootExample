package com.example.springboot.web.service;

import org.springframework.stereotype.Service;

@Service
public class LoginService {
	
	public boolean validateLogin(String userName,String password) {
		
		return userName.equalsIgnoreCase("suyog") && password.equalsIgnoreCase("123");
	}

}
