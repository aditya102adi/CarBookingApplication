package com.example.demo.startegies.implementation;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Driver;
import com.example.demo.entity.Payment;
import com.example.demo.entity.Wallet;
import com.example.demo.entity.enums.TransactionMethod;
import com.example.demo.service.WalletService;
import com.example.demo.startegies.PaymentStargergy;

import lombok.RequiredArgsConstructor;


// Rider -> 100
// Driver -> 70 Deduct 30Rs from the driver's wallet - 30Rs is Uber comission


@Service
@RequiredArgsConstructor
public class CODPaymentStargergy implements PaymentStargergy {
	
	private final WalletService walletService;
	
	@Override
	public void processPayment(Payment payment) {
		
		Driver driver = payment.getRide().getDriver();
		
		Wallet driverWallet = walletService.findByUser(driver.getUser());
		
		double platformComsiion = payment.getAmount() * PLATFORM_COMISSION;
		
		walletService.deductMoneyFromWallet
		(driver.getUser(), platformComsiion, null, payment.getRide(), TransactionMethod.RIDE);
		
		
	}
	
}
