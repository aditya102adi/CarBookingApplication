package com.example.demo.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.example.demo.entity.Ride;
import com.example.demo.entity.RideRequest;
import com.example.demo.entity.Rider;
import com.example.demo.entity.enums.RideStatus;
import com.example.demo.entity.Driver;

public interface RideService {
	
	Ride getRideById(Long rideID);
	
	Ride createNewRide(RideRequest rideRequest, Driver driver);
	
	Ride updateRideStatus(Ride ride, RideStatus rideStatus);
	
	Page<Ride> getAllRidesOfDriver(Driver driver, PageRequest pageRequest);
	
	Page<Ride> getAllRidesOfRider(Rider rider, PageRequest pageRequest);
}
