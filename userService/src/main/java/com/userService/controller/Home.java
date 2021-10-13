package com.userService.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Home {
	
	
	@RequestMapping("/welcome")
	public String welcome() {
		String text = "Welcome to the private home controller.";
		return text;
	}
}
