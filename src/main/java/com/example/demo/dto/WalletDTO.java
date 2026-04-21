package com.example.demo.dto;

import java.util.List;

import lombok.Builder;
import lombok.Data;


@Builder
@Data
public class WalletDTO {
	
	private Long id;
	private UserDTO user;
	private Double balance;
	List<WalletTransactionDTO> transactions;
	
}
