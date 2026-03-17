package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.RideRequestDTO;

public interface RiderService {
	
	RideRequestDTO requestRide(RideRequestDTO rideRequestDTO);
	
	RideRequestDTO cancelRide(Long rideId);
	
	RideRequestDTO rateDriver(Long rideId, Integer rating);
	
	List<RideRequestDTO> getAllMyRides(); 
}
