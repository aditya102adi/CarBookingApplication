package com.example.demo.dto;

import java.util.Arrays;

public class PointDTO {
	
	private double[] coordinates;
	private String type = new String("Point");
	
	public PointDTO() {
		// TODO Auto-generated constructor stub
	}

	public PointDTO(double[] coordinates, String type) {
		super();
		this.coordinates = coordinates;
		this.type = type;
	}

	public PointDTO(double[] coordinates) {
		this.coordinates = coordinates;
	}

	public double[] getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(double[] coordinates) {
		this.coordinates = coordinates;
	}

	public String getType() {
	    return type == null ? "Point" : type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "PointDTO [coordinates=" + Arrays.toString(coordinates) + ", type=" + type + "]";
	}

	
}
