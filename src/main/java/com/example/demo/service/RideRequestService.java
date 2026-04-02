package com.example.demo.service;

import com.example.demo.entity.RideRequest;

public interface RideRequestService {
	
	RideRequest findRideRequestById(Long rideRequestId);

	void updateRideRequest(RideRequest rideRequest);
	
}
