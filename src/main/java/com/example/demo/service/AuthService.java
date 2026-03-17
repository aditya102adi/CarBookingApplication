package com.example.demo.service;

import com.example.demo.dto.DriverDTO;
import com.example.demo.dto.SignUpDTO;
import com.example.demo.dto.UserDTO;

public interface AuthService {
	
	// return tokens
	String login(String email, String password);
	
	UserDTO signUp(SignUpDTO signUpDTO);
	
	DriverDTO onboardNewDriver(Long userId);
	
}
