package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.RideRequestDTO;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.service.RiderService;

@RestController
@RequestMapping("/rider")
public class RiderController {
	
	private final RiderService riderService;
	
	public RiderController(RiderService riderService) {
		this.riderService = riderService;
	}


	@PostMapping("/requestRide")
	public ResponseEntity<RideRequestDTO> requestRide(@RequestBody RideRequestDTO rideRequestDTO) {
		
		System.err.println("From Controller: " + rideRequestDTO);
		
		return ResponseEntity.ok(riderService.requestRide(rideRequestDTO));
	}
	
	@GetMapping("/test")
	public String test() {
	    throw new ResourceNotFoundException("Test exception");
	}
}
