package com.example.demo.service.implementation;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.demo.dto.RideRequestDTO;
import com.example.demo.entity.Driver;
import com.example.demo.entity.Ride;
import com.example.demo.entity.enums.RideStatus;
import com.example.demo.service.RideService;


@Service
public class RideServiceImple implements RideService {

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
	public Ride createNewRide(RideRequestDTO rideRequestDTO, Driver driver) {
		// TODO Auto-generated method stub
		return null;
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
	
	
	
}
