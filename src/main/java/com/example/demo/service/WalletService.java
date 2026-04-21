package com.example.demo.service;

import com.example.demo.entity.Ride;
import com.example.demo.entity.User;
import com.example.demo.entity.Wallet;
import com.example.demo.entity.enums.TransactionMethod;

public interface WalletService {
	
	Wallet addMoneyToWallet(User user, Double amount, String transactionID, Ride ride, TransactionMethod transactionMethod);
		
	void withdrawAllMyMoneyFromWallet(); // get the money from wallet back to my account // ONLY TO DRIVER
	
	Wallet findWalletById(Long id);
	
	Wallet createNewWallet(User user);
	
	Wallet findByUser(User user);
	
	Wallet deductMoneyFromWallet(User user, Double amount, String transactionID, Ride ride, TransactionMethod transactionMethod);
}
