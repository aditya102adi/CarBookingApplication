package com.example.demo.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.example.demo.dto.DriverDTO;
import com.example.demo.dto.RideDTO;
import com.example.demo.entity.Driver;

public interface DriverService {
	
	RideDTO acceptRide(Long rideRequestId);
	
	RideDTO cancelRide(Long rideId);
	
	RideDTO startRide(Long rideId, String otp);
	
	RideDTO endRide(Long rideId);
	
	RideDTO rateRider(Long riderId);
	
	DriverDTO getMyProfile();
	
	Page<RideDTO> getAllMyRides(PageRequest pageRequest);
	
	Driver getCurrentDriver();
	
	Driver updateDriverAvailability(Driver driver, boolean available);
	
}	
