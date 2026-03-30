package com.example.demo.startegies.implementation;

import org.springframework.stereotype.Service;

import com.example.demo.entity.RideRequest;
import com.example.demo.service.DistanceService;
import com.example.demo.startegies.RideFareCalculationStartergy;


@Service
public class RideFareSurgePricingFareCalculationStrategy implements RideFareCalculationStartergy {
	
	private final DistanceService distanceService;
	
	// TODO : Call the weather API 
	// TODO : On basis of weather decide the SURGE_FACTOR
	private static final double SURGE_FACTOR = 2;
	
	public RideFareSurgePricingFareCalculationStrategy(DistanceService distanceService) {
		this.distanceService = distanceService;
	}
	
	
	@Override
	public double calculateRideFare(RideRequest rideRequest) {
		double distance = distanceService.calculateDistance(rideRequest.getPickupLocation(), rideRequest.getDropOffLocation());
		return distance * RIDE_FARE_MULTIPLIER * SURGE_FACTOR;	
	}
	
}
 