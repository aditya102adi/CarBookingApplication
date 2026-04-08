package com.example.demo.service.implementation;

import java.util.Set;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.example.demo.dto.DriverDTO;
import com.example.demo.dto.SignUpDTO;
import com.example.demo.dto.UserDTO;
import com.example.demo.entity.User;
import com.example.demo.entity.enums.Role;
import com.example.demo.exceptions.RuntimeConflictException;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.AuthService;
import com.example.demo.service.RiderService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class AuthServiceImple implements AuthService {
	
	private final ModelMapper modelMapper;
	private final UserRepository userRepository;
	private final RiderService riderService;
	

	@Override
	public String login(String email, String password) {
		return null;
	}

	
	
	@Override
	@Transactional
	public UserDTO signUp(SignUpDTO signUpDTO) {
		
		userRepository.findByEmail(signUpDTO.getEmail()).orElseThrow(() -> 
			new RuntimeConflictException("Cannot signup, User already exits with email: " + signUpDTO.getEmail()));

		
		User mappedUser = modelMapper.map(signUpDTO, User.class);
		mappedUser.setRoles(Set.of(Role.RIDER)); // By default a user is rider
		
		User savedUser = userRepository.save(mappedUser);
		
		
		// Create the user related entities
		
		riderService.createNewRider(savedUser);
		// TODO : Add wallet related service 
		
		return modelMapper.map(savedUser, UserDTO.class);
	}

	
	@Override
	public DriverDTO onboardNewDriver(Long userId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}
