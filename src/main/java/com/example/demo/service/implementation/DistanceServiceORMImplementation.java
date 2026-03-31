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
			
			System.out.println(OSRM_API + uri);
			
			OSRMResponseDto responseDTO = RestClient.builder()
			.baseUrl(OSRM_API)
			.build()
			.get()
			.uri(uri)
			.header("Accept-Encoding", "identity") 
			.retrieve()
			.body(OSRMResponseDto.class);
			
			System.out.println("The Distance is: " + responseDTO.getRoutes().get(0));
			
			return responseDTO.getRoutes().get(0).getDistance() / 1000; // return the distance in kilometer
		}
		
		catch (Exception e) {
			throw new RuntimeException("Error Getting Data from OSRM : " + e.getMessage());
		}
		
	}
	
}

class OSRMResponseDto {
	
	public OSRMResponseDto() {}
	
	private List<OSRMRoute> routes;

	public List<OSRMRoute> getRoutes() {
		return routes;
	}

	public void setRoutes(List<OSRMRoute> routes) {
		this.routes = routes;
	}

	@Override
	public String toString() {
		return "OSRMResponseDto [routes=" + routes + "]";
	}
}

class OSRMRoute {
	
	public OSRMRoute() {}
	
	private Double distance;

	public Double getDistance() {
		return distance;
	}

	public void setDistance(Double distance) {
		this.distance = distance;
	}

	@Override
	public String toString() {
		return "OSRMRoute [distance=" + distance + "]";
	}
	
}



