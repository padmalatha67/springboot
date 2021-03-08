package com.zemoso.springboot.springbootassignment.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

	@GetMapping("/login/page")
	public String showLoginPage() {
		
		//return "plain-login";
		return "login-page1";
		
	}
	
	// mapping for access denied
	@GetMapping("/access/denied")
	public String showAcessDenied() {
		
		return "access-denied";
		
	}
}
