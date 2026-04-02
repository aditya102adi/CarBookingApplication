package com.example.demo.dto;

public class RiderDTO {

	private UserDTO user;
	
	private Double rating;
	
	public RiderDTO() {
		// TODO Auto-generated constructor stub
	}

	public RiderDTO(UserDTO user, Double rating) {
		super();
		this.user = user;
		this.rating = rating;
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

	@Override
	public String toString() {
		return "RiderDTO [user=" + user + ", rating=" + rating + "]";
	}
	
}
