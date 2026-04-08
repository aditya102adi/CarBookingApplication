package com.example.demo.entity;

import java.time.LocalDateTime;

import org.locationtech.jts.geom.Point;
import org.hibernate.annotations.CreationTimestamp;

import com.example.demo.entity.enums.PaymentMethod;
import com.example.demo.entity.enums.RideRequestStatus;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class RideRequest {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
	
	private Double fare;
	
	
}
