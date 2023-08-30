package com.app.gaz.sbrestapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {
	
	@GetMapping("/api")
	public String helloWorld() {
		return "From Rest Api Spring Boot";
	}

}
