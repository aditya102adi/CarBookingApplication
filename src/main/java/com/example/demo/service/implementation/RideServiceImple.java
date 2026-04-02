package com.example.demo.service.implementation;

import java.util.Random;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.example.demo.dto.RideRequestDTO;
import com.example.demo.entity.Driver;
import com.example.demo.entity.Ride;
import com.example.demo.entity.RideRequest;
import com.example.demo.entity.enums.RideRequestStatus;
import com.example.demo.entity.enums.RideStatus;
import com.example.demo.repository.RideRepository;
import com.example.demo.service.RideRequestService;
import com.example.demo.service.RideService;

import jakarta.transaction.Transactional;


@Service
public class RideServiceImple implements RideService {
	
	private final RideRepository rideRepository;
	private final RideRequestService rideRequestService;
	private final ModelMapper modelMapper;
	
	
	public RideServiceImple(RideRepository rideRepository, RideRequestService rideRequestService, ModelMapper modelMapper) {
		this.rideRepository = rideRepository;
		this.rideRequestService = rideRequestService;
		this.modelMapper = modelMapper;
	}
	
	
	@Override
	public Ride getRideById(Long rideID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void matchWithDriver(RideRequestDTO rideRequestDTO) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Ride createNewRide(RideRequest rideRequest, Driver driver) {
		
		rideRequest.setRideRequestStatus(RideRequestStatus.BOOKED);
		
		Ride ride = modelMapper.map(rideRequest, Ride.class);
		
		System.err.println("Ride is created with ID: " + ride.getId());
		
		ride.setRideStatus(RideStatus.CONFIRMED);
		ride.setDriver(driver);
		
		String otp = generateRandomOtp();
		ride.setOtp(otp);
		//ride.setId(null);
		
		
		rideRequestService.updateRideRequest(rideRequest);
		return rideRepository.save(ride);
	}

	@Override
	public Ride updateRideStatus(Long rideId, RideStatus rideStatus) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Ride> getAllRiderOfDriver(Long driverId, PageRequest pageRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Ride> getAllRiderOfRider(Long riderId, PageRequest pageRequest) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	private String generateRandomOtp() {
		// 4 digit OTP
		Random random = new Random();
		int num = random.nextInt(1000, 10000);
		
		return String.valueOf(num);
	}
	
	
	
}
