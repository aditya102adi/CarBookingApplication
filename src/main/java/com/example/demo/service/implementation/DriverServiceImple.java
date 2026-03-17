package com.example.demo.service.implementation;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dto.DriverDTO;
import com.example.demo.dto.RideDTO;
import com.example.demo.service.DriverService;


@Service
public class DriverServiceImple implements DriverService {

	@Override
	public RideDTO acceptRide(Long rideId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RideDTO cancelRide(Long rideId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RideDTO startRide(Long rideId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RideDTO endRide(Long rideId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RideDTO rateRider(Long riderId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RideDTO rateDriver(Long rideId, Integer rating) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DriverDTO getMyProfile() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RideDTO> getAllMyRides() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
