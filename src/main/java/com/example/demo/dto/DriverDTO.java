package com.example.demo.dto;

public class DriverDTO {
	
	private Long id;
	private UserDTO user;
	
	private Double rating;
	
	private Boolean isAvailable;
	
	private String vechileID;
	
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

	public Boolean getIsAvailable() {
		return isAvailable;
	}

	public void setIsAvailable(Boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public String getVechileID() {
		return vechileID;
	}

	public void setVechileID(String vechileID) {
		this.vechileID = vechileID;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
}
