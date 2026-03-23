package com.example.demo.startegies;

import java.util.List;

import com.example.demo.entity.Driver;
import com.example.demo.entity.RideRequest;

public interface DriverMatchingStartergy {
	
	List<Driver> findMatchingDriver(RideRequest rideRequest); 
	
}
