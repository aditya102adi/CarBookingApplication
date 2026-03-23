package com.example.demo.dto;

import java.time.LocalDateTime;


import com.example.demo.entity.enums.PaymentMethod;
import com.example.demo.entity.enums.RideRequestStatus;


public class RideRequestDTO {
	
	private Long id;
	
	private PointDTO pickupLocation;
	private PointDTO dropOffLocation;
	
	private LocalDateTime requestTime;
	
	
	private RiderDTO rider; 
	
	
	private PaymentMethod paymentMethod;
	private RideRequestStatus rideRequestStatus;
	
	public RideRequestDTO() {
		// TODO Auto-generated constructor stub
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

	public LocalDateTime getRequestTime() {
		return requestTime;
	}

	public void setRequestTime(LocalDateTime requestTime) {
		this.requestTime = requestTime;
	}

	public RiderDTO getRider() {
		return rider;
	}

	public void setRider(RiderDTO rider) {
		this.rider = rider;
	}

	public PaymentMethod getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(PaymentMethod paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public RideRequestStatus getRideRequestStatus() {
		return rideRequestStatus;
	}

	public void setRideRequestStatus(RideRequestStatus rideRequestStatus) {
		this.rideRequestStatus = rideRequestStatus;
	}

	@Override
	public String toString() {
		return "RideRequestDTO [id=" + id + ", pickupLocation=" + pickupLocation + ", dropOffLocation="
				+ dropOffLocation + ", requestTime=" + requestTime + ", rider=" + rider + ", paymentMethod="
				+ paymentMethod + ", rideRequestStatus=" + rideRequestStatus + "]";
	}
		
}
