package com.example.demo.repository;

import java.util.List;

import org.geolatte.geom.Point;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Driver;


// ST_Distance(point1, point2)
// ST_WITHIN(point1, point2)

@Repository
public interface DriverRepository extends JpaRepository<Driver, Long> {
	
	@Query(value = """
		    SELECT d.*, 
		           ST_Distance(d.current_location, :pickupLocation) AS distance
		    FROM drivers d
		    WHERE d.is_avaliable = true 
		      AND ST_DWithin(d.current_location, :pickupLocation, 10000)
		    ORDER BY distance
		    LIMIT 10
		""", nativeQuery = true)
	List<Driver> findTenNearestDrivers(Point pickupLocation);
	
	
}
