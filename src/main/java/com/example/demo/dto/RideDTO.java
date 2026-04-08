package com.example.demo.dto;

import java.time.LocalDateTime;


import com.example.demo.entity.enums.PaymentMethod;
import com.example.demo.entity.enums.RideStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class RideDTO {
	
	private Long id;
	private PointDTO pickupLocation;
	private PointDTO dropOffLocation;
	
	private LocalDateTime createdTime; 
	private RiderDTO rider;
	private DriverDTO driver;
	private PaymentMethod paymentMethod;
	private RideStatus rideStatus; 
	
    private String otp;
    private Double fare;
    private LocalDateTime startedAt;
    private LocalDateTime endedAt;
    
}
