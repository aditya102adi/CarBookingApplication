package com.example.demo.dto;

import java.time.LocalDateTime;

import org.geolatte.geom.Point;

import com.example.demo.entity.Driver;
import com.example.demo.entity.enums.PaymentMethod;
import com.example.demo.entity.enums.RideStatus;


public class RideDTO {
	
	private Long id;
	private Point pickupLocation;
	private Point dropOffLocation;
	
	private LocalDateTime requestTime; // when driver accept the ride
	private RiderDTO rider;
	private Driver driver;
	private PaymentMethod paymentMethod;
	
	
	private RideStatus rideStatus; 
	private Double fair;
	private LocalDateTime startAt; // uses OTP and start the ride
	private LocalDateTime endedAt;
	
	
	public RideDTO() {
		// TODO Auto-generated constructor stub
	}


	public RideDTO(Long id, Point pickupLocation, Point dropOffLocation, LocalDateTime requestTime, RiderDTO rider,
			Driver driver, PaymentMethod paymentMethod, RideStatus rideStatus, Double fair, LocalDateTime startAt,
			LocalDateTime endedAt) {
		super();
		this.id = id;
		this.pickupLocation = pickupLocation;
		this.dropOffLocation = dropOffLocation;
		this.requestTime = requestTime;
		this.rider = rider;
		this.driver = driver;
		this.paymentMethod = paymentMethod;
		this.rideStatus = rideStatus;
		this.fair = fair;
		this.startAt = startAt;
		this.endedAt = endedAt;
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


	public Driver getDriver() {
		return driver;
	}


	public void setDriver(Driver driver) {
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


	public Double getFair() {
		return fair;
	}


	public void setFair(Double fair) {
		this.fair = fair;
	}


	public LocalDateTime getStartAt() {
		return startAt;
	}


	public void setStartAt(LocalDateTime startAt) {
		this.startAt = startAt;
	}


	public LocalDateTime getEndedAt() {
		return endedAt;
	}


	public void setEndedAt(LocalDateTime endedAt) {
		this.endedAt = endedAt;
	}
	
}
