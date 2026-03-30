package com.example.demo.service;


import org.locationtech.jts.geom.Point;

public interface DistanceService {
	
	double calculateDistance(Point src, Point dest);
	
}
