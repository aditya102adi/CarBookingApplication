package com.example.demo.service.implementation;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.example.demo.dto.RideRequestDTO;
import com.example.demo.entity.Ride;
import com.example.demo.entity.RideRequest;
import com.example.demo.entity.Rider;
import com.example.demo.entity.User;
import com.example.demo.entity.enums.RideRequestStatus;
import com.example.demo.repository.RideRequestRepository;
import com.example.demo.repository.RiderRepository;
import com.example.demo.service.RiderService;
import com.example.demo.startegies.DriverMatchingStartergy;
import com.example.demo.startegies.RideFareCalculationStartergy;


@Service
public class RiderServiceImple implements RiderService {
	
	private final ModelMapper modelMapper;
	private final RideFareCalculationStartergy rideFareCalculationStartergy;
	private final DriverMatchingStartergy driverMatchingStartergy;
	private final RideRequestRepository rideRequestRepository;
	private final RiderRepository riderRepository;
	
	
	public RiderServiceImple(
			ModelMapper modelMapper, 
			RideFareCalculationStartergy rideFareCalculationStartergy,
			DriverMatchingStartergy driverMatchingStartergy,
			RideRequestRepository rideRequestRepository,
			RiderRepository riderRepository) {
		
		
		this.modelMapper = modelMapper;
		this.rideFareCalculationStartergy = rideFareCalculationStartergy;
		this.driverMatchingStartergy = driverMatchingStartergy;
		this.rideRequestRepository = rideRequestRepository;
		this.riderRepository = riderRepository;
	}
	
	
	@Override
	public RideRequestDTO requestRide(RideRequestDTO rideRequestDTO) {
		
		RideRequest rideRequest = modelMapper.map(rideRequestDTO, RideRequest.class);
		rideRequest.setRideRequestStatus(RideRequestStatus.PENDING);
		
		Double fair = rideFareCalculationStartergy.calculateRideFare(rideRequest);
		rideRequest.setFair(fair);
		
		RideRequest savedRideRequest = rideRequestRepository.save(rideRequest);
		
		//BROADCAST THE MESSAGE TO ALL THE DRIVER 
		driverMatchingStartergy.findMatchingDriver(rideRequest);
		
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

	
}
