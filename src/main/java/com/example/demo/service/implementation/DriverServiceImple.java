package com.example.demo.service.implementation;

import java.time.LocalDateTime;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import com.example.demo.dto.DriverDTO;
import com.example.demo.dto.RideDTO;
import com.example.demo.entity.Driver;
import com.example.demo.entity.Ride;
import com.example.demo.entity.RideRequest;
import com.example.demo.entity.enums.RideRequestStatus;
import com.example.demo.entity.enums.RideStatus;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.repository.DriverRepository;
import com.example.demo.service.DriverService;
import com.example.demo.service.RideRequestService;
import com.example.demo.service.RideService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DriverServiceImple implements DriverService {

	private final RideRequestService rideRequestService;
	private final DriverRepository driverRepository;
	private final RideService rideService;
	private final ModelMapper modelMapper;


	@Override
	@Transactional
	public RideDTO acceptRide(Long rideRequestId) {

		RideRequest rideRequest = rideRequestService.findRideRequestById(rideRequestId);

		if (!rideRequest.getRideRequestStatus().equals(RideRequestStatus.PENDING)) {
			throw new RuntimeException(
					"RideRequest cannot be accepted, status is " + rideRequest.getRideRequestStatus());
		}

		Driver currentDriver = getCurrentDriver();
		if (!currentDriver.getIsAvaliable()) {
			throw new RuntimeException("Driver cannot accept ride due to unavailability");
		}

		
		Driver savedDriver = updateDriverAvailability(currentDriver, false);

		Ride ride = rideService.createNewRide(rideRequest, savedDriver);
		return modelMapper.map(ride, RideDTO.class);
	}

	@Override
	@Transactional
	public RideDTO cancelRide(Long rideId) {

		Ride ride = rideService.getRideById(rideId);
		Driver driver = getCurrentDriver();

		if (!driver.equals(ride.getDriver())) {
			throw new RuntimeException("Driver cannot start a start as he has accepted it earlier");
		}

		if (!ride.getRideStatus().equals(RideStatus.CONFIRMED)) {
			throw new RuntimeException("Ride cannot be cancelled, invalid status " + ride.getRideStatus());
		}

		
		rideService.updateRideStatus(ride, RideStatus.CANCELLED);
		updateDriverAvailability(driver, true);
		
		return modelMapper.map(ride, RideDTO.class);
	}

	@Override
	public RideDTO startRide(Long rideId, String otp) {

		Ride ride = rideService.getRideById(rideId);
		Driver driver = getCurrentDriver();

		if (!driver.equals(ride.getDriver())) {
			throw new RuntimeException("Driver cannot start a start as he has accepted it earlier");
		}

		if (!ride.getRideStatus().equals(RideStatus.CONFIRMED))
			throw new RuntimeException("Ride is not available, Ride status is: " + ride.getRideStatus());

		if (!otp.equals(ride.getOtp())) {
			throw new RuntimeException("Otp is not valid");
		}

		ride.setStartAt(LocalDateTime.now());
		Ride savedRide = rideService.updateRideStatus(ride, RideStatus.ONGOING);

		RideDTO startedRide = modelMapper.map(savedRide, RideDTO.class);
		startedRide.setStartedAt(ride.getStartAt());

		return modelMapper.map(savedRide, RideDTO.class);
	}

	@Override
	@Transactional
	public RideDTO endRide(Long rideId) {
		
		Ride ride = rideService.getRideById(rideId);
		Driver driver = getCurrentDriver();
		
		if(!ride.getDriver().equals(driver)) {
			throw new RuntimeException("Driver cannot end a ride as he has not accepted it earlier");
		}
		
		if(!ride.getRideStatus().equals(RideStatus.ONGOING)) {
            throw new RuntimeException("Ride status is not ONGOING hence cannot be ended, status: "+ride.getRideStatus());
        }
		
		ride.setEndedAt(LocalDateTime.now());
		Ride savedRide = rideService.updateRideStatus(ride, RideStatus.ENDED);
		updateDriverAvailability(driver, true);
		
		return modelMapper.map(savedRide, RideDTO.class);
	}

	@Override
	public RideDTO rateRider(Long riderId) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public DriverDTO getMyProfile() {

		Driver currentDriver = getCurrentDriver();
		return modelMapper.map(currentDriver, DriverDTO.class);

	}

	@Override
	public Page<RideDTO> getAllMyRides(PageRequest pageRequest) {

		Driver currentDriver = getCurrentDriver();
		return rideService.getAllRidesOfDriver(currentDriver, pageRequest)
				.map(ride -> modelMapper.map(ride, RideDTO.class));
	}

	@Override
	public Driver getCurrentDriver() {
		return driverRepository.findById(2L)
				.orElseThrow(() -> new ResourceNotFoundException("Current Driver Not Found"));
	}

	@Override
	public Driver updateDriverAvailability(Driver driver, boolean available) {

		driver.setIsAvaliable(available);
		return driverRepository.save(driver);

	}
	
	

}
