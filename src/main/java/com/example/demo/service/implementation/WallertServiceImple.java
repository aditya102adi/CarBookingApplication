package com.example.demo.service.implementation;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.example.demo.dto.RideDTO;
import com.example.demo.dto.WalletDTO;
import com.example.demo.dto.WalletTransactionDTO;
import com.example.demo.entity.Ride;
import com.example.demo.entity.User;
import com.example.demo.entity.Wallet;
import com.example.demo.entity.WalletTransaction;
import com.example.demo.entity.enums.TransactionMethod;
import com.example.demo.entity.enums.TransactionType;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.repository.WalletRepository;
import com.example.demo.service.WalletService;
import com.example.demo.service.WalletTransactionService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class WallertServiceImple implements WalletService {
	
	private final WalletRepository walletRepository;
	private final ModelMapper modelMapper;
	private final WalletTransactionService walletTransactionService;
	
	@Override
	@Transactional
	public Wallet addMoneyToWallet(User user, Double amount, String transactionID, Ride ride, TransactionMethod transactionMethod) {
		
		Wallet wallet = findByUser(user); // Get the wallet of the user
		wallet.setBalance(wallet.getBalance() + amount);
		
		 WalletTransaction walletTransaction = WalletTransaction.builder()
				 .transactionID(transactionID)
				 .ride(ride)
				 .wallet(wallet)
				 .transactionType(TransactionType.CREDIT)
				 .transactionMethod(transactionMethod)
				 .build(); 
		 
		 walletTransactionService.createNewWalletTransaction(walletTransaction);

		return walletRepository.save(wallet);
		
	}
	
	
	@Override
	@Transactional
	public Wallet deductMoneyFromWallet(User user, Double amount, String transactionID, Ride ride,
			TransactionMethod transactionMethod) {
		
		
		Wallet wallet = findByUser(user); 
		wallet.setBalance(wallet.getBalance() - amount);
		
		WalletTransaction walletTransaction = WalletTransaction.builder()
				 .transactionID(transactionID)
				 .ride(ride)
				 .wallet(wallet)
				 .transactionType(TransactionType.DEBIT)
				 .transactionMethod(transactionMethod)
				 .build(); 
		 
		 walletTransactionService.createNewWalletTransaction(walletTransaction);
		
		return walletRepository.save(wallet);
		
	}

	
	@Override
	public Wallet createNewWallet(User user) {
		Wallet wallet = new Wallet();
		wallet.setUser(user);
		
		return walletRepository.save(wallet);
	}
	
	@Override
	public Wallet findWalletById(Long id) {
		return walletRepository.findById(id).
				orElseThrow(()-> new ResourceNotFoundException("Wallet Not Found with ID: " + id));
	}
	
	
	@Override
	public void withdrawAllMyMoneyFromWallet() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public Wallet findByUser(User user) {
		return walletRepository.findByUser(user)
				.orElseThrow(()-> new ResourceNotFoundException("Wallet Not Found For User with ID: " + user.getId()));
	}
	
	
}
