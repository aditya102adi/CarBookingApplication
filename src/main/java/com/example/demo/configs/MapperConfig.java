package com.example.demo.configs;


import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.locationtech.jts.geom.Point;

import com.example.demo.dto.PointDTO;
import com.example.demo.utils.GeometryUtil;

@Configuration
public class MapperConfig {
	
	@Bean
    public ModelMapper modelMapper() {
        
		ModelMapper mapper = new ModelMapper();
		
		// convert pointDTO -> Point
		mapper.typeMap(PointDTO.class, Point.class).setConverter(context -> {
			PointDTO pointDTO = context.getSource();
			return GeometryUtil.createPoint(pointDTO);
		});
		
		
		// Point to PointDTO
		mapper.typeMap(Point.class, PointDTO.class).setConverter(context -> {
			Point point = context.getSource();
			
			// Extract the longitude and latitude and store in the array
			double[] coordinates =  { point.getX(), point.getY() };
			
			return new PointDTO(coordinates);
		});
		
		return mapper;
    }
	
}
