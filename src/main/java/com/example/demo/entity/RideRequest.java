package com.example.demo.entity;

import java.time.LocalDateTime;

import org.geolatte.geom.Point;
import org.hibernate.annotations.CreationTimestamp;

import com.example.demo.entity.enums.PaymentMethod;
import com.example.demo.entity.enums.RideRequestStatus;

import jakarta.persistence.*;

@Entity
public class RideRequest {
	
	@Id
	private Long id;
	
	@Column(columnDefinition = "Geometry(Point, 4326)")
	private Point pickupLocation;
	
	@Column(columnDefinition = "Geometry(Point, 4326)")
	private Point dropOffLocation;
	
	@CreationTimestamp
	private LocalDateTime requestTime;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Rider rider; //one rider can have multiple ride request
	
	@Enumerated(EnumType.STRING)
	private PaymentMethod paymentMethod;
	
	@Enumerated(EnumType.STRING)
	private RideRequestStatus rideRequestStatus;
	
	private Double fair;
	
	public RideRequest() {
		
	}

	public RideRequest(Long id, Point pickupLocation, Point dropOffLocation, LocalDateTime requestTime, Rider rider,
			PaymentMethod paymentMethod, RideRequestStatus rideRequestStatus) {
		super();
		this.id = id;
		this.pickupLocation = pickupLocation;
		this.dropOffLocation = dropOffLocation;
		this.requestTime = requestTime;
		this.rider = rider;
		this.paymentMethod = paymentMethod;
		this.rideRequestStatus = rideRequestStatus;
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

	public PaymentMethod getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(PaymentMethod paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public Double getFair() {
		return fair;
	}

	public void setFair(Double fair) {
		this.fair = fair;
	}

	public RideRequestStatus getRideRequestStatus() {
		return rideRequestStatus;
	}

	public void setRideRequestStatus(RideRequestStatus rideRequestStatus) {
		this.rideRequestStatus = rideRequestStatus;
	}

	@Override
	public String toString() {
		return "RideRequest [id=" + id + ", pickupLocation=" + pickupLocation + ", dropOffLocation=" + dropOffLocation
				+ ", requestTime=" + requestTime + ", rider=" + rider + ", paymentMethod=" + paymentMethod
				+ ", rideRequestStatus=" + rideRequestStatus + "]";
	}
	
}
