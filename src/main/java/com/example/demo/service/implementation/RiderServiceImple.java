package com.example.demo.service.implementation;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.example.demo.dto.RideRequestDTO;
import com.example.demo.entity.RideRequest;
import com.example.demo.entity.Rider;
import com.example.demo.entity.User;
import com.example.demo.entity.enums.RideRequestStatus;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.repository.RideRequestRepository;
import com.example.demo.repository.RiderRepository;
import com.example.demo.service.RiderService;
import com.example.demo.startegies.RideStratergyManager;

import jakarta.transaction.Transactional;


@Service
public class RiderServiceImple implements RiderService {
	
	private final ModelMapper modelMapper;
	private final RideStratergyManager  rideStratergyManager;
	private final RideRequestRepository rideRequestRepository;
	private final RiderRepository riderRepository;
	
	
	public RiderServiceImple(
			ModelMapper modelMapper, 
			RideStratergyManager rideStratergyManager,
			RideRequestRepository rideRequestRepository,
			RiderRepository riderRepository) {
		
		
		this.modelMapper = modelMapper;
		this.rideStratergyManager = rideStratergyManager;
		this.rideRequestRepository = rideRequestRepository;
		this.riderRepository = riderRepository;
	}
	
	
	@Override
	@Transactional
	public RideRequestDTO requestRide(RideRequestDTO rideRequestDTO) {
		
		Rider rider = getCurrentRider();
		
		RideRequest rideRequest = modelMapper.map(rideRequestDTO, RideRequest.class);
		rideRequest.setRideRequestStatus(RideRequestStatus.PENDING);
		
		rideRequest.setRider(rider);
		
		Double fare = rideStratergyManager.rideFareCalculationStartergy().calculateRideFare(rideRequest);
		rideRequest.setFare(fare);
		
		RideRequest savedRideRequest = rideRequestRepository.save(rideRequest);
		
		//BROADCAST THE MESSAGE TO ALL THE DRIVER 
		rideStratergyManager.driverMatchingStratergy(rider.getRating()).findMatchingDriver(rideRequest);
		
		return modelMapper.map(savedRideRequest, RideRequestDTO.class);
	}

	@Override
	public RideRequestDTO cancelRide(Long rideId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RideRequestDTO rateDriver(Long rideId, Integer rating) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RideRequestDTO> getAllMyRides() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Rider createNewRider(User user) {
		Rider rider = new Rider();
		rider.setRating(0.0);
		rider.setUser(user);
		 
		return riderRepository.save(rider);
	}
	
	public Rider getCurrentRider() {
		return riderRepository.findById(1L).orElseThrow(
				()-> new ResourceNotFoundException("Rider not found with ID: " + 1));
	}

	
}
