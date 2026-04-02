package com.example.demo.dto;

import java.time.LocalDateTime;


import com.example.demo.entity.Driver;
import com.example.demo.entity.enums.PaymentMethod;
import com.example.demo.entity.enums.RideStatus;


public class RideDTO {
	
	private Long id;
	private PointDTO pickupLocation;
	private PointDTO dropOffLocation;
	
	private LocalDateTime createdTime; // when driver accept the ride
	private RiderDTO rider;
	private DriverDTO driver;
	private PaymentMethod paymentMethod;
	
	private RideStatus rideStatus; 
	
    private String otp;

    private Double fare;
    
    private LocalDateTime startedAt;
    
    private LocalDateTime endedAt;
	
	
    
    
    public RideDTO() {
		
	}

	public RideDTO(Long id, PointDTO pickupLocation, PointDTO dropOffLocation, LocalDateTime createdTime,
			RiderDTO rider, DriverDTO driver, PaymentMethod paymentMethod, RideStatus rideStatus, String otp, Double fare,
			LocalDateTime startedAt, LocalDateTime endedAt) {
		super();
		this.id = id;
		this.pickupLocation = pickupLocation;
		this.dropOffLocation = dropOffLocation;
		this.createdTime = createdTime;
		this.rider = rider;
		this.driver = driver;
		this.paymentMethod = paymentMethod;
		this.rideStatus = rideStatus;
		this.otp = otp;
		this.fare = fare;
		this.startedAt = startedAt;
		this.endedAt = endedAt;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public PointDTO getPickupLocation() {
		return pickupLocation;
	}

	public void setPickupLocation(PointDTO pickupLocation) {
		this.pickupLocation = pickupLocation;
	}

	public PointDTO getDropOffLocation() {
		return dropOffLocation;
	}

	public void setDropOffLocation(PointDTO dropOffLocation) {
		this.dropOffLocation = dropOffLocation;
	}

	public LocalDateTime getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(LocalDateTime createdTime) {
		this.createdTime = createdTime;
	}

	public RiderDTO getRider() {
		return rider;
	}

	public void setRider(RiderDTO rider) {
		this.rider = rider;
	}

	public DriverDTO getDriver() {
		return driver;
	}

	public void setDriver(DriverDTO driver) {
		this.driver = driver;
	}

	public PaymentMethod getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(PaymentMethod paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public RideStatus getRideStatus() {
		return rideStatus;
	}

	public void setRideStatus(RideStatus rideStatus) {
		this.rideStatus = rideStatus;
	}

	public String getOtp() {
		return otp;
	}

	public void setOtp(String otp) {
		this.otp = otp;
	}

	public Double getFare() {
		return fare;
	}

	public void setFare(Double fare) {
		this.fare = fare;
	}

	public LocalDateTime getStartedAt() {
		return startedAt;
	}

	public void setStartedAt(LocalDateTime startedAt) {
		this.startedAt = startedAt;
	}

	public LocalDateTime getEndedAt() {
		return endedAt;
	}

	public void setEndedAt(LocalDateTime endedAt) {
		this.endedAt = endedAt;
	}
	
	
}
