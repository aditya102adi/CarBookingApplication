package com.example.demo.exceptions;

public class BadCredentialException extends RuntimeException {
	
	public BadCredentialException(String msg) {
		super(msg);
	}
	
}
