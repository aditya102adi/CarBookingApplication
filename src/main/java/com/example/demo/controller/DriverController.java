package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.RideDTO;
import com.example.demo.dto.RideStartDTO;
import com.example.demo.service.DriverService;

@RestController
@RequestMapping("/drivers")
public class DriverController {
	
	
	private final DriverService driverService;
	
	public DriverController(DriverService driverService) {
		this.driverService = driverService;
	}
	
	
	@PostMapping("/acceptRide/{rideRequestId}")
    public ResponseEntity<RideDTO> acceptRide(@PathVariable Long rideRequestId) {
        return ResponseEntity.ok(driverService.acceptRide(rideRequestId));
    }
	
	@PostMapping("/startRide/{rideRequestId}")
    public ResponseEntity<RideDTO> startRide(@PathVariable Long rideRequestId, 
    											@RequestBody RideStartDTO rideStartDTO) {
		
        return ResponseEntity.ok(driverService.startRide(rideRequestId, rideStartDTO.getOtp()));
    }
	
}
