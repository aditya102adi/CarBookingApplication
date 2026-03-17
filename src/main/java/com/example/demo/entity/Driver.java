package com.example.demo.entity;

import org.geolatte.geom.Point;

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
	private Boolean isAvaliable;
	
	@Column(columnDefinition = "Geometry(Point, 4326)") // Earth co-ordinate [4326] // for hibernate
	Point currentLocation; // support for longitude and latitude
	
	public Driver() {
		// TODO Auto-generated constructor stub
	}

	public Driver(Long id, Double rating, User user, Boolean isAvaliable, Point currentLocation) {
		super();
		this.id = id;
		this.rating = rating;
		this.user = user;
		this.isAvaliable = isAvaliable;
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
		return isAvaliable;
	}

	public void setIsAvaliable(Boolean isAvaliable) {
		this.isAvaliable = isAvaliable;
	}

	public Point getCurrentLocation() {
		return currentLocation;
	}

	public void setCurrentLocation(Point currentLocation) {
		this.currentLocation = currentLocation;
	}
	
}
