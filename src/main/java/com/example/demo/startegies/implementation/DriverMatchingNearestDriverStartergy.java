package com.example.demo.startegies.implementation;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dto.RideRequestDTO;
import com.example.demo.entity.Driver;
import com.example.demo.startegies.DriverMatchingStartergy;


@Service
public class DriverMatchingNearestDriverStartergy implements DriverMatchingStartergy {
	
	@Override
	public List<Driver> findMatchingDriver(RideRequestDTO rideRequestDTO) {
		return null;
	}
	
}
