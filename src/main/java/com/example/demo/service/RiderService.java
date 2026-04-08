package com.example.demo.service;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.example.demo.dto.DriverDTO;
import com.example.demo.dto.RideDTO;
import com.example.demo.dto.RideRequestDTO;
import com.example.demo.dto.RiderDTO;
import com.example.demo.entity.Rider;
import com.example.demo.entity.User;


public interface RiderService {

    RideRequestDTO requestRide(RideRequestDTO rideRequestDto);

    RideDTO cancelRide(Long rideId);

    DriverDTO rateDriver(Long rideId, Integer rating);

    RiderDTO getMyProfile();

    Page<RideDTO> getAllMyRides(PageRequest pageRequest);

    Rider createNewRider(User user);

    Rider getCurrentRider();
}
