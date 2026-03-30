package com.example.demo.repository;

import java.util.List;

import org.locationtech.jts.geom.Point;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Driver;


// ST_Distance(point1, point2) -- Get the distance in meters
// ST_WITHIN(point1, point2) -- Within a range 

@Repository
public interface DriverRepository extends JpaRepository<Driver, Long> {
	
	
	@Query(value = "SELECT d.*, ST_Distance(d.current_location, :pickupLocation) AS distance "
			+ "FROM drivers d "
			+ "WHERE d.is_available = true "
			+ "AND ST_DWithin(d.current_location, :pickupLocation, 10000) "
			+ "ORDER BY DISTANCE "
			+ "LIMIT 10", 
			nativeQuery = true)
	List<Driver> findTenNearestDrivers(Point pickupLocation);
	
	
	@Query(value = "SELECT d.* " +
	        "FROM drivers d " +
	        "WHERE d.is_available = true " +
	        "AND ST_DWithin(d.current_location, :pickupLocation, 150000) " +
	        "ORDER BY d.rating DESC " +
	        "LIMIT 10",
	        nativeQuery = true)
	List<Driver> findTenNearByTopRatedDrivers(Point pickupLocation);
	
}
