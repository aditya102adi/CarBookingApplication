package com.example.demo.service.implementation;

import java.util.List;

import org.locationtech.jts.geom.Point;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import com.example.demo.service.DistanceService;


@Service
public class DistanceServiceORMImplementation  implements DistanceService {
	
	private static final String OSRM_API = "https://router.project-osrm.org/route/v1/driving/";
	
	@Override
	public double calculateDistance(Point src, Point dest) {
		
		try {
			
			String uri = src.getX()+","+src.getY()+";"+dest.getX()+","+dest.getY();
			
			OSRMResponseDto responseDTO = RestClient.builder()
			.baseUrl(OSRM_API)
			.build()
			.get()
			.uri(uri)
			.retrieve()
			.body(OSRMResponseDto.class);
			
			return responseDTO.getRoutes().get(0).getDistance() / 1000; // return the distance in kilometer
		}
		
		catch (Exception e) {
			throw new RuntimeException("Error Getting Data from OSRM : " + e.getMessage());
		}
		
	}
	
}

class OSRMResponseDto {
	
	private List<OSRMRoute> routes;

	public List<OSRMRoute> getRoutes() {
		return routes;
	}

	public void setRoutes(List<OSRMRoute> routes) {
		this.routes = routes;
	}
	
}

class OSRMRoute {
	
	private Double distance;

	public Double getDistance() {
		return distance;
	}

	public void setDistance(Double distance) {
		this.distance = distance;
	} 
	
}



