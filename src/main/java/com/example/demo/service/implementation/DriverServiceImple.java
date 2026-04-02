package com.example.demo.service.implementation;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.example.demo.dto.DriverDTO;
import com.example.demo.dto.RideDTO;
import com.example.demo.entity.Driver;
import com.example.demo.entity.Ride;
import com.example.demo.entity.RideRequest;
import com.example.demo.entity.enums.RideRequestStatus;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.repository.DriverRepository;
import com.example.demo.service.DriverService;
import com.example.demo.service.RideRequestService;
import com.example.demo.service.RideService;

import jakarta.transaction.Transactional;


@Service
public class DriverServiceImple implements DriverService {


	private final RideRequestService rideRequestService;
    private final DriverRepository driverRepository;
    private final RideService rideService;
    private final ModelMapper modelMapper;
	
	public DriverServiceImple(DriverRepository driverRepository, 
			RideRequestService rideRequestService, 
			RideService rideService, 
			ModelMapper modelMapper) {
		this.driverRepository = driverRepository;
		this.rideRequestService = rideRequestService;
		this.rideService = rideService;
		this.modelMapper = modelMapper;
		
	}
	
	
	@Override
    @Transactional
    public RideDTO acceptRide(Long rideRequestId) {
        RideRequest rideRequest = rideRequestService.findRideRequestById(rideRequestId);

        if(!rideRequest.getRideRequestStatus().equals(RideRequestStatus.PENDING)) {
            throw new RuntimeException("RideRequest cannot be accepted, status is "+ rideRequest.getRideRequestStatus());
        }

        Driver currentDriver = getCurrentDriver();
        if(!currentDriver.getIsAvaliable()) {
            throw new RuntimeException("Driver cannot accept ride due to unavailability");
        }

        

        Ride ride = rideService.createNewRide(rideRequest, currentDriver);
        return modelMapper.map(ride, RideDTO.class);
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
	
	@Override
	public Driver getCurrentDriver() {
		return driverRepository.findById(2L).
				orElseThrow(() -> new ResourceNotFoundException("Current Driver Not Found"));
	}
	
}
