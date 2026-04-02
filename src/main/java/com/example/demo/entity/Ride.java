package com.example.demo.entity;

import java.time.LocalDateTime;

import org.locationtech.jts.geom.Point;

import org.hibernate.annotations.CreationTimestamp;

import com.example.demo.entity.enums.PaymentMethod;
import com.example.demo.entity.enums.RideStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table
public class Ride {
	
	@Id
	private Long id;
	
	@Column(columnDefinition = "Geometry(Point, 4326)")
	private Point pickupLocation;
	
	@Column(columnDefinition = "Geometry(Point, 4326)")
	private Point dropOffLocation;
	
	@CreationTimestamp
	private LocalDateTime createdTime; // when driver accept the ride
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Rider rider;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Driver driver;
	
	@Enumerated(EnumType.STRING)
	private PaymentMethod paymentMethod;
	
	@Enumerated(EnumType.STRING)
	private RideStatus rideStatus; 
	
	@Column
	private Double fare;
	
	@Column
	private LocalDateTime startedAt; // uses OTP and start the ride
	
	@Column
	private LocalDateTime endedAt; 
	
	@Column
	private String otp;
	
	public Ride() {
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


	public Rider getRider() {
		return rider;
	}

	public void setRider(Rider rider) {
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

	public Double getFare() {
		return fare;
	}

	public void setFare(Double fare) {
		this.fare = fare;
	}

	public LocalDateTime getStartAt() {
		return startedAt;
	}

	public void setStartAt(LocalDateTime startAt) {
		this.startedAt = startAt;
	}

	public LocalDateTime getEndedAt() {
		return endedAt;
	}

	public void setEndedAt(LocalDateTime endedAt) {
		this.endedAt = endedAt;
	}

	public String getOtp() {
		return otp;
	}

	public void setOtp(String otp) {
		this.otp = otp;
	}

	public LocalDateTime getCreatedTime() {
		return createdTime;
	}


	public void setCreatedTime(LocalDateTime createdTime) {
		this.createdTime = createdTime;
	}
	
}
