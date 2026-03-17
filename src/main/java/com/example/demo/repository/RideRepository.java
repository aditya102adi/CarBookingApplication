package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Ride;

@Repository
public interface RideRepository extends JpaRepository<Ride, Long> {

}
