package com.zemoso.springboot.springbootassignment.controller;

import com.zemoso.springboot.springbootassignment.service.ClaimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {


	@GetMapping("/")
	public String showHome() {
		
		return "home";
	}

}
