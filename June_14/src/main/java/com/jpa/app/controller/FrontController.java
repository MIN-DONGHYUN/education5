package com.jpa.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FrontController {

	@RequestMapping(value="/") 
	public String main() { 
		return "redirect:/board/list"; 
	}
	
}
