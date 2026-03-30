package com.example.demo.advices;

import java.time.LocalDateTime;

public class ApiResponse<T> {
	
	
	private LocalDateTime timestamp;
	
	private T data;
	
	private ApiError error;
	
	public ApiResponse() {
		this.timestamp = LocalDateTime.now();
	}
	
	public ApiResponse(T data) {
		this.data = data;
	}
	
	public ApiResponse(ApiError error) {
		this.error = error;
	}
	
}
