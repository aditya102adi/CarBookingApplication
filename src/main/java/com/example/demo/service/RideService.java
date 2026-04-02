package com.example.demo.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.example.demo.dto.RideRequestDTO;
import com.example.demo.entity.Ride;
import com.example.demo.entity.RideRequest;
import com.example.demo.entity.enums.RideStatus;
import com.example.demo.entity.Driver;

public interface RideService {
	
	Ride getRideById(Long rideID);
	
	void matchWithDriver(RideRequestDTO rideRequestDTO);
	
	Ride createNewRide(RideRequest rideRequest, Driver driver);
	
	Ride updateRideStatus(Long rideId, RideStatus rideStatus);
	
	Page<Ride> getAllRiderOfDriver(Long driverId, PageRequest pageRequest);
	
	Page<Ride> getAllRiderOfRider(Long riderId, PageRequest pageRequest);
}
