package com.jpa.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FrontController {

	@RequestMapping("/") 
	public String main() { 
	//	return "redirect:/guest/list"; 
		return "redirect:/guest/"; 
	}
	
}
