package com.example.demo.startegies;

import java.util.List;

import com.example.demo.dto.RideRequestDTO;
import com.example.demo.entity.Driver;

public interface DriverMatchingStartergy {
	
	List<Driver> findMatchingDriver(RideRequestDTO rideRequestDTO); 
	
}
