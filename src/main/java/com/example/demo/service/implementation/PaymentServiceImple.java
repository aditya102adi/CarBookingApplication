package com.example.demo.service.implementation;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Payment;
import com.example.demo.entity.Ride;
import com.example.demo.repository.PaymentRepository;
import com.example.demo.service.PaymentService;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class PaymentServiceImple implements PaymentService {
	
	private final PaymentRepository paymentRepository;
	
	@Override
	public Payment createNewPayment(Ride ride) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void processPayment(Payment payment) {
		// TODO Auto-generated method stub
		
	}
	
}
