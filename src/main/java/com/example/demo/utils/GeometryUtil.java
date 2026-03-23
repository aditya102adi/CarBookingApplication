package com.example.demo.utils;


import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.PrecisionModel;
import org.locationtech.jts.geom.Point;


import com.example.demo.dto.PointDTO;

public class GeometryUtil {
	
	public static Point createPoint(PointDTO pointDTO) {
		GeometryFactory geometryFactory = new GeometryFactory(new PrecisionModel(), 4326);
		
		Coordinate coordinate = new Coordinate(
				pointDTO.getCoordinates()[0],	// longitude
				pointDTO.getCoordinates()[1]);	// latitude
		
		return geometryFactory.createPoint(coordinate);
	}
	
}
