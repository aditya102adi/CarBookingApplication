package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;
import com.example.demo.exceptions.ResourceNotFoundException;

@RestController
@RequestMapping("/auth")
public class AuthController {
	
	@GetMapping("/user")
	public User getUser() {
	    User user = new User();
	    user.setName("Aditya");
	    user.setEmail("aditya");
	    return user;
	}
	
}
