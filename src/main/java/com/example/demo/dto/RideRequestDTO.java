package com.example.demo.dto;

import java.time.LocalDateTime;

import org.geolatte.geom.Point;

import com.example.demo.entity.enums.PaymentMethod;
import com.example.demo.entity.enums.RideRequestStatus;


public class RideRequestDTO {
	
	private Long id;
	private Point pickupLocation;
	private Point dropOffLocation;
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

	public Point getPickupLocation() {
		return pickupLocation;
	}

	public void setPickupLocation(Point pickupLocation) {
		this.pickupLocation = pickupLocation;
	}

	public Point getDropOffLocation() {
		return dropOffLocation;
	}

	public void setDropOffLocation(Point dropOffLocation) {
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
	
	
	
}
