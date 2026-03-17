package com.example.demo.service;

import org.geolatte.geom.Point;

public interface DistanceService {
	
	double calculateDistance(Point src, Point dest);
	
}
