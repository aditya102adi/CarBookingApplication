package com.example.demo.entity;

import java.time.LocalDateTime;

import org.geolatte.geom.Point;
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
	private LocalDateTime requestTime; // when driver accept the ride
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Rider rider;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Driver driver;
	
	@Enumerated(EnumType.STRING)
	private PaymentMethod paymentMethod;
	
	@Enumerated(EnumType.STRING)
	private RideStatus rideStatus; 
	
	@Column
	private Double fair;
	
	@Column
	private LocalDateTime startAt; // uses OTP and start the ride
	
	@Column
	private LocalDateTime endedAt; 
	
	public Ride() {
		// TODO Auto-generated constructor stub
	}

	public Ride(Long id, Point pickupLocation, Point dropOffLocation, LocalDateTime requestTime, Rider rider,
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
