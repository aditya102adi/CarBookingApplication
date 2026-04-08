package com.example.demo.entity;

import org.locationtech.jts.geom.Point;

import jakarta.persistence.*;

@Entity
@Table(name = "driver")
public class Driver {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private Double rating;
	
	@OneToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	@Column
	private Boolean isAvailable;
	
	@Column(columnDefinition = "Geometry(Point, 4326)") // Earth co-ordinate [4326] // for hibernate
	private Point currentLocation; // support for longitude and latitude
	
	
	@Column
	private String vechileID;
	
	public Driver() {
		// TODO Auto-generated constructor stub
	}

	public Driver(Long id, Double rating, User user, Boolean isAvailable, Point currentLocation) {
		super();
		this.id = id;
		this.rating = rating;
		this.user = user;
		this.isAvailable = isAvailable;
		this.currentLocation = currentLocation;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getRating() {
		return rating;
	}

	public void setRating(Double rating) {
		this.rating = rating;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Boolean getIsAvaliable() {
		return isAvailable;
	}

	public void setIsAvaliable(Boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public Point getCurrentLocation() {
		return currentLocation;
	}

	public void setCurrentLocation(Point currentLocation) {
		this.currentLocation = currentLocation;
	}
	
}
