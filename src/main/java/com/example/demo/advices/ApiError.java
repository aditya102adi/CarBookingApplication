package com.example.demo.advices;


import lombok.Builder;
import lombok.Data;

import java.util.List;

import org.springframework.http.HttpStatus;


@Data
@Builder
public class ApiError {
	
	private String message;
	private HttpStatus status;
	private List<String> subErrors;

	public ApiError() {
		// TODO Auto-generated constructor stub
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}
	

	public List<String> getSubErrors() {
		return subErrors;
	}

	public void setSubErrors(List<String> subErrors) {
		this.subErrors = subErrors;
	}

	public ApiError(String message, HttpStatus status, List<String> subErros) {
		super();
		this.message = message;
		this.status = status;
		this.subErrors = subErros;
	}

}

