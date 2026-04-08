package com.example.demo.service.implementation;

import org.springframework.stereotype.Service;

import com.example.demo.entity.RideRequest;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.repository.RideRequestRepository;
import com.example.demo.service.RideRequestService;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@Service
public class RideRequestServiceImple implements RideRequestService {
		
	private final RideRequestRepository rideRequestRepository;
	
	
	@Override
	public RideRequest findRideRequestById(Long rideRequestId) {
		
		return rideRequestRepository.findById(rideRequestId).
				orElseThrow(() -> new ResourceNotFoundException("Ride request not found with ID: " + rideRequestId));
		
	}
	
	@Override
    public void update(RideRequest rideRequest) {
        rideRequestRepository.findById(rideRequest.getId())
                .orElseThrow(() -> new ResourceNotFoundException("RideRequest not found with id: "+rideRequest.getId()));
        rideRequestRepository.save(rideRequest);
    }
	
}
