package com.example.demo.startegies.implementation;

import org.springframework.stereotype.Service;


import com.example.demo.entity.RideRequest;
import com.example.demo.service.DistanceService;
import com.example.demo.startegies.RideFareCalculationStartergy;


@Service
public class RideFairDefaultFareCalculation implements RideFareCalculationStartergy {
	
	private final DistanceService distanceService;
	
	public RideFairDefaultFareCalculation(DistanceService distanceService) {
		this.distanceService = distanceService;
	}
	
	@Override
	public double calculateRideFare(RideRequest rideRequest) {
		
		// Get the distance in meters
		Double distance = distanceService.calculateDistance(rideRequest.getPickupLocation(), 
				rideRequest.getDropOffLocation());
		
		
		return distance * RIDE_FARE_MULTIPLIER;
	}
}