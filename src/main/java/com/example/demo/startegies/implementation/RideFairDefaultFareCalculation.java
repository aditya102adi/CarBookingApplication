package com.example.demo.startegies.implementation;

import org.springframework.stereotype.Service;

import com.example.demo.dto.RideRequestDTO;
import com.example.demo.startegies.RideFareCalculationStartergy;


@Service
public class RideFairDefaultFareCalculation implements RideFareCalculationStartergy {

	@Override
	public double calculateRideFare(RideRequestDTO rideRequestDTO) {
		
		return 0;
	}
	
	
	
}
