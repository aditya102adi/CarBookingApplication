package com.example.demo.startegies;

import java.time.LocalTime;

import org.springframework.stereotype.Component;

import com.example.demo.startegies.implementation.DriverMatchingHighestRatedDriverStrategy;
import com.example.demo.startegies.implementation.DriverMatchingNearestDriverStartergy;
import com.example.demo.startegies.implementation.RiderFareDefaultFareCalculationStrategy;
import com.example.demo.startegies.implementation.RideFareSurgePricingFareCalculationStrategy;

@Component
public class RideStratergyManager {
	
	private final DriverMatchingHighestRatedDriverStrategy highestRatedDriverStrategy;
	private final DriverMatchingNearestDriverStartergy nearestDriverStartergy;
	private final RideFareSurgePricingFareCalculationStrategy surgePricingFareCalculationStrategy;
	private final RiderFareDefaultFareCalculationStrategy defaultFareCalculationStrategy;
	
	public RideStratergyManager(DriverMatchingHighestRatedDriverStrategy highestRatedDriverStrategy, 
			DriverMatchingNearestDriverStartergy nearestDriverStartergy, 
			RideFareSurgePricingFareCalculationStrategy surgePricingFareCalculationStrategy,
			RiderFareDefaultFareCalculationStrategy defaultFareCalculationStrategy) {
		
		this.highestRatedDriverStrategy = highestRatedDriverStrategy;
		this.nearestDriverStartergy = nearestDriverStartergy;
		this.surgePricingFareCalculationStrategy = surgePricingFareCalculationStrategy;
		this.defaultFareCalculationStrategy = defaultFareCalculationStrategy;
	}
	
	
	public DriverMatchingStartergy driverMatchingStratergy(double riderRating) {
		if(riderRating > 4.7) {
			return highestRatedDriverStrategy; 
		}
		else {
			return nearestDriverStartergy;
		}
	}
	
	public RideFareCalculationStartergy rideFareCalculationStartergy() {
		
		// Surge Time - 6:00 PM - 9:00
		LocalTime surgeStartTime = LocalTime.of(18, 0);
		LocalTime surgeEndTime = LocalTime.of(21, 0);
		
		LocalTime currentTime = LocalTime.now(); 
		
		boolean isSurgeTime = currentTime.isAfter(surgeStartTime) && currentTime.isBefore(surgeEndTime);
		
		if(isSurgeTime) {
			return surgePricingFareCalculationStrategy;
		}
		else {
			return defaultFareCalculationStrategy;
		}
		
	}
}
