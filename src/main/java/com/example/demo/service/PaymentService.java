package com.example.demo.service;

import com.example.demo.entity.Payment;
import com.example.demo.entity.Ride;

public interface PaymentService {
	
	void processPayment(Payment payment);
	
	Payment createNewPayment(Ride ride);
	
}
