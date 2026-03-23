package com.example.demo.service.implementation;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.example.demo.dto.RideRequestDTO;
import com.example.demo.entity.RideRequest;
import com.example.demo.service.RiderService;


@Service
public class RiderServiceImple implements RiderService {
	
	private final ModelMapper modelMapper;
	
	public RiderServiceImple(ModelMapper modelMapper) {
		this.modelMapper = modelMapper;
	}
	
	
	@Override
	public RideRequestDTO requestRide(RideRequestDTO rideRequestDTO) {
		
		RideRequest rideRequest = modelMapper.map(rideRequestDTO, RideRequest.class);
		
		System.out.println(rideRequest);
		System.out.println(rideRequestDTO);
		
		return null;
		
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
	
	
	
}
