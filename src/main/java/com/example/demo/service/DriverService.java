package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.DriverDTO;
import com.example.demo.dto.RideDTO;

public interface DriverService {
	
	RideDTO acceptRide(Long rideId);
	
	RideDTO cancelRide(Long rideId);
	
	RideDTO startRide(Long rideId);
	
	RideDTO endRide(Long rideId);
	
	RideDTO rateRider(Long riderId);
	
	RideDTO rateDriver(Long rideId, Integer rating);
	
	DriverDTO getMyProfile();
	
	List<RideDTO> getAllMyRides();
	
}	
