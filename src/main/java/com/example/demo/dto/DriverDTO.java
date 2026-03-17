package com.example.demo.dto;

public class DriverDTO {
	
	private UserDTO user;
	
	private Double rating;
	
	public DriverDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public UserDTO getUser() {
		return user;
	}

	public void setUser(UserDTO user) {
		this.user = user;
	}

	public Double getRating() {
		return rating;
	}

	public void setRating(Double rating) {
		this.rating = rating;
	}
}
