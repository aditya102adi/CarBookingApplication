package com.example.demo.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import com.example.demo.entity.enums.TransactionMethod;
import com.example.demo.entity.enums.TransactionType;

import jakarta.persistence.*;


@Entity
@Table
public class WalletTransaction {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Double amount;
	
	@Enumerated(EnumType.STRING)
	private TransactionType transactionType;
	
	@Enumerated(EnumType.STRING)
	private TransactionMethod transactionMethod;
	
	@OneToOne
	private Ride ride;
	
	@Column
	private String transactionID;
	
	@ManyToOne
	private Wallet wallet;
	
	@CreationTimestamp
	private LocalDateTime createdAt;
	
	public WalletTransaction() {
		// TODO Auto-generated constructor stub
	}

	public WalletTransaction(Long id, Double amount, TransactionType transactionType,
			TransactionMethod transactionMethod, Ride ride, String transactionID, Wallet wallet,
			LocalDateTime createdAt) {
		super();
		this.id = id;
		this.amount = amount;
		this.transactionType = transactionType;
		this.transactionMethod = transactionMethod;
		this.ride = ride;
		this.transactionID = transactionID;
		this.wallet = wallet;
		this.createdAt = createdAt;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public TransactionType getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(TransactionType transactionType) {
		this.transactionType = transactionType;
	}

	public TransactionMethod getTransactionMethod() {
		return transactionMethod;
	}

	public void setTransactionMethod(TransactionMethod transactionMethod) {
		this.transactionMethod = transactionMethod;
	}

	public Ride getRide() {
		return ride;
	}

	public void setRide(Ride ride) {
		this.ride = ride;
	}

	public String getTransactionID() {
		return transactionID;
	}

	public void setTransactionID(String transactionID) {
		this.transactionID = transactionID;
	}

	public Wallet getWallet() {
		return wallet;
	}

	public void setWallet(Wallet wallet) {
		this.wallet = wallet;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	
}
