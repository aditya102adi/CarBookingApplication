package com.example.demo.service.implementation;

import java.util.Random;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import com.example.demo.entity.Driver;
import com.example.demo.entity.Ride;
import com.example.demo.entity.RideRequest;
import com.example.demo.entity.Rider;
import com.example.demo.entity.enums.RideRequestStatus;
import com.example.demo.entity.enums.RideStatus;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.repository.RideRepository;
import com.example.demo.service.RideRequestService;
import com.example.demo.service.RideService;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class RideServiceImple implements RideService {


	private final RideRepository rideRepository;
	private final RideRequestService rideRequestService;
	private final ModelMapper modelMapper;
	
	
	@Override
	public Ride getRideById(Long rideID) {
		return rideRepository.findById(rideID).
				orElseThrow(()-> new ResourceNotFoundException("'Ride not found with Id: " + rideID));
	}

	
	@Override
	public Ride createNewRide(RideRequest rideRequest, Driver driver) {
		
		rideRequest.setRideRequestStatus(RideRequestStatus.BOOKED);
		
		Ride ride = modelMapper.map(rideRequest, Ride.class);
		ride.setRideStatus(RideStatus.CONFIRMED);
		ride.setDriver(driver);
		ride.setOtp(generateRandomOtp());
		
		System.out.println("Ride fare" + ride.getFare());
		
		rideRequestService.update(rideRequest);
		return rideRepository.save(ride);
	}

	@Override
	public Ride updateRideStatus(Ride ride, RideStatus rideStatus) {
		
		ride.setRideStatus(rideStatus);
		return rideRepository.save(ride);
	}

	@Override
	public Page<Ride> getAllRidesOfDriver(Driver driver, PageRequest pageRequest) {
		return rideRepository.findByDriver(driver, pageRequest);
	}
	
	@Override
	public Page<Ride> getAllRidesOfRider(Rider rider, PageRequest pageRequest) {
		return rideRepository.findByRider(rider, pageRequest);
	}
	
	
	private String generateRandomOtp() {
		// 4 digit OTP
		Random random = new Random();
		int num = random.nextInt(1000, 10000);
		
		return String.valueOf(num);
	}

}
