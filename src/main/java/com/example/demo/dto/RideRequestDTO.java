package com.example.demo.dto;

import java.time.LocalDateTime;


import com.example.demo.entity.enums.PaymentMethod;
import com.example.demo.entity.enums.RideRequestStatus;

import lombok.Data;



@Data
public class RideRequestDTO {
	
	private Long id;
	
	private PointDTO pickupLocation;
	private PointDTO dropOffLocation;
	private LocalDateTime requestTime;
	
	private RiderDTO rider; 
	private Double fare;
	
	private PaymentMethod paymentMethod;
	private RideRequestStatus rideRequestStatus;
	
	
}
