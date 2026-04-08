package com.example.demo.service.implementation;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.demo.dto.DriverDTO;
import com.example.demo.dto.RideDTO;
import com.example.demo.dto.RideRequestDTO;
import com.example.demo.dto.RiderDTO;
import com.example.demo.entity.Driver;
import com.example.demo.entity.Ride;
import com.example.demo.entity.RideRequest;
import com.example.demo.entity.Rider;
import com.example.demo.entity.User;
import com.example.demo.entity.enums.RideRequestStatus;
import com.example.demo.entity.enums.RideStatus;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.repository.RideRequestRepository;
import com.example.demo.repository.RiderRepository;
import com.example.demo.service.DriverService;
import com.example.demo.service.RideService;
import com.example.demo.service.RiderService;
import com.example.demo.startegies.RideStratergyManager;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class RiderServiceImple implements RiderService {
	
	private final ModelMapper modelMapper;
	private final RideStratergyManager  rideStratergyManager;
	private final RideRequestRepository rideRequestRepository;
	private final RiderRepository riderRepository;
	private final RideService rideService;
	private final DriverService driverService;
	
	
	
	
	@Override
	public RideRequestDTO requestRide(RideRequestDTO rideRequestDTO) {
		
		Rider rider = getCurrentRider();
		
		RideRequest rideRequest = modelMapper.map(rideRequestDTO, RideRequest.class);
		
		rideRequest.setRideRequestStatus(RideRequestStatus.PENDING);
		
		rideRequest.setRider(rider);
		
		Double fare = rideStratergyManager.rideFareCalculationStartergy().calculateRideFare(rideRequest);
		rideRequest.setFare(fare);
		
		RideRequest savedRideRequest = rideRequestRepository.save(rideRequest);
		
		// TODO : Send notification to all the drivers about the current RIDE
		
		List<Driver> drivers = rideStratergyManager.driverMatchingStratergy(rider.getRating()).findMatchingDriver(rideRequest);
		
		return modelMapper.map(savedRideRequest, RideRequestDTO.class);
	}

	@Override
	public RideDTO cancelRide(Long rideId) {
		Rider rider = getCurrentRider();
		Ride ride = rideService.getRideById(rideId);
		
		if(!rider.equals(ride.getRider())) {
            throw new RuntimeException(("Rider does not own this ride with id: "+rideId));
        }

        if(!ride.getRideStatus().equals(RideStatus.CONFIRMED)) {
            throw new RuntimeException("Ride cannot be cancelled, invalid status: "+ride.getRideStatus());
        }
        
        Ride savedRide = rideService.updateRideStatus(ride, RideStatus.CANCELLED);
        driverService.updateDriverAvailability(ride.getDriver(), true);

        return modelMapper.map(savedRide, RideDTO.class);
	}

	@Override
	public Page<RideDTO> getAllMyRides(PageRequest pageRequest) {
		Rider currentRider = getCurrentRider();
        return rideService.getAllRidesOfRider(currentRider, pageRequest).map(
                ride -> modelMapper.map(ride, RideDTO.class)
        );
	}
	
	@Override
	public RiderDTO getMyProfile() {
		Rider currentRider = getCurrentRider();
        return modelMapper.map(currentRider, RiderDTO.class);
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

	@Override
	public DriverDTO rateDriver(Long rideId, Integer rating) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
