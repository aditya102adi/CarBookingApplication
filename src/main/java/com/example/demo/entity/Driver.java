package com.example.demo.entity;

import org.locationtech.jts.geom.Point;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "driver")
public class Driver {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private Double rating;
	
	@OneToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	@Column
	private Boolean isAvailable;
	
	@Column(columnDefinition = "Geometry(Point, 4326)") // Earth co-ordinate [4326] // for hibernate
	private Point currentLocation; // support for longitude and latitude
	
	
	@Column
	private String vechileID;
	
	
}
