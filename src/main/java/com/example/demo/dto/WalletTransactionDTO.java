package com.example.demo.dto;

import java.time.LocalDateTime;

import com.example.demo.entity.enums.TransactionMethod;
import com.example.demo.entity.enums.TransactionType;

import lombok.Builder;
import lombok.Data;


@Builder
@Data
public class WalletTransactionDTO {
	
	private Long id;	
	private Double amount;
	private TransactionType transactionType;
	private TransactionMethod transactionMethod;
	private RideDTO ride;
	private String transactionID;
	private WalletDTO wallet;
	private LocalDateTime createdAt;

}
