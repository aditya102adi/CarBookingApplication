package com.example.demo.startegies;

import com.example.demo.entity.RideRequest;

public interface RideFareCalculationStartergy {
	
	final double RIDE_FARE_MULTIPLIER = 10.0;
	
	double calculateRideFare(RideRequest rideRequest);
	
}
