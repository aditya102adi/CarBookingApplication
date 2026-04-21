package com.example.demo.service.implementation;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.example.demo.dto.WalletTransactionDTO;
import com.example.demo.entity.WalletTransaction;
import com.example.demo.repository.WalletTransactionRepository;
import com.example.demo.service.WalletTransactionService;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class WalletTransactionServiceImple implements WalletTransactionService {
	
	private final WalletTransactionRepository walletTransactionRepository;
	private final ModelMapper modelMapper;
	

	public void createNewWalletTransaction(WalletTransactionDTO walletTransactionDTO) {
		
		WalletTransaction walletTransaction = modelMapper.map(walletTransactionDTO, WalletTransaction.class);
		walletTransactionRepository.save(walletTransaction);
		
	}
	
	@Override
	public void createNewWalletTransaction(WalletTransaction walletTransaction) {
		// TODO Auto-generated method stub
		
	}
	
}
