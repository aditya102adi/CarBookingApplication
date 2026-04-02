package com.example.demo.service.implementation;

import org.springframework.stereotype.Service;

import com.example.demo.entity.RideRequest;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.repository.RideRequestRepository;
import com.example.demo.service.RideRequestService;


@Service
public class RideRequestServiceImple implements RideRequestService {
		
	private final RideRequestRepository rideRequestRepository;
	
	public RideRequestServiceImple(RideRequestRepository rideRequestRepository) {
		this.rideRequestRepository = rideRequestRepository;
	}
	
	
	@Override
	public RideRequest findRideRequestById(Long rideRequestId) {
		
		return rideRequestRepository.findById(rideRequestId).
				orElseThrow(() -> new ResourceNotFoundException("Ride request not found with ID: " + rideRequestId));
		
	}
	
	@Override
	public void updateRideRequest(RideRequest rideRequest) {
		
		rideRequestRepository.findById(rideRequest.getId()).
			orElseThrow(() -> new ResourceNotFoundException("Riderequest not found with id: " + rideRequest.getId()));
		
		rideRequestRepository.save(rideRequest);
	}
	
}
