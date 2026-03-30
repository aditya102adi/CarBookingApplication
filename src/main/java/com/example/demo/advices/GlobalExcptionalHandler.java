package com.example.demo.advices;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.demo.exceptions.BadCredentialException;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.exceptions.RuntimeConflictException;

@RestControllerAdvice
public class GlobalExcptionalHandler {
	
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiResponse<?>> handleResouceNotFound(ResourceNotFoundException exception) {
		
		ApiError error = new ApiError();
		error.setMessage(exception.getMessage());
		error.setStatus(HttpStatus.NOT_FOUND);
		
		return generateApiResponse(error);
	}
	
	@ExceptionHandler(BadCredentialException.class)
	public ResponseEntity<ApiResponse<?>> handleBadCredentialRequest(BadCredentialException exception) {
		
		ApiError error = new ApiError();
		error.setMessage(exception.getMessage());
		error.setStatus(HttpStatus.BAD_REQUEST);
		
		return generateApiResponse(error);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ApiResponse<?>> handleInternalServerError(Exception exception) {
		
		ApiError error = new ApiError();
		error.setMessage(exception.getMessage());
		error.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
		
		return generateApiResponse(error);
	}
	
	@ExceptionHandler(RuntimeConflictException.class)
	public ResponseEntity<ApiResponse<?>> handleRuntimeConflictException(RuntimeConflictException exception) {
		
		ApiError error = new ApiError();
		error.setMessage(exception.getMessage());
		error.setStatus(HttpStatus.CONFLICT); 
		
		return generateApiResponse(error);
	}
	
	
	private ResponseEntity<ApiResponse<?>> generateApiResponse(ApiError error) {		
		return new ResponseEntity<>(new ApiResponse<>(error), error.getStatus());
	}
	
}
