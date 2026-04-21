package com.example.demo.startegies;

import com.example.demo.entity.Payment;

public interface PaymentStargergy {
	
	Double PLATFORM_COMISSION = 0.3;
	
	void processPayment(Payment payment);
	
}
