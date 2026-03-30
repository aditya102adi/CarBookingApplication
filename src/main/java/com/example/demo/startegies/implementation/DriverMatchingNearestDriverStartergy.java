package com.example.demo.startegies.implementation;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Driver;
import com.example.demo.entity.RideRequest;
import com.example.demo.repository.DriverRepository;
import com.example.demo.startegies.DriverMatchingStartergy;


@Service
public class DriverMatchingNearestDriverStartergy implements DriverMatchingStartergy {
	
	private final DriverRepository driverRepository;
	
	public DriverMatchingNearestDriverStartergy(DriverRepository driverRepository) {
		this.driverRepository = driverRepository;
	}
	
	@Override
	public List<Driver> findMatchingDriver(RideRequest rideRequest) {
		return driverRepository.findTenNearestDrivers(rideRequest.getPickupLocation());
	}
	
	
}
