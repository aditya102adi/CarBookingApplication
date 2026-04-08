package com.example.demo.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Driver;
import com.example.demo.entity.Ride;
import com.example.demo.entity.Rider;

@Repository
public interface RideRepository extends JpaRepository<Ride, Long> {
	
	Page<Ride> findByRider(Rider rider, Pageable pageRequest);

    Page<Ride> findByDriver(Driver driver, Pageable pageRequest);
	
}
