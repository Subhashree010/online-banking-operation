package com.techm.nine.obs.entity;

import java.sql.Timestamp;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class TransactionHistory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String description;

	@Column(nullable = false)
	private double amount;

	private java.sql.Timestamp transactionDate;

	@ManyToOne
	@JoinColumn(name = "account_id") // Assuming the column name in the TransactionHistory table
	private Account account;

	public TransactionHistory() {
		super();
	}

	public TransactionHistory(Long id, String description, double amount, Timestamp transactionDate, Account account) {
		super();
		this.id = id;
		this.description = description;
		this.amount = amount;
		this.transactionDate = transactionDate;
		this.account = account;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public java.sql.Timestamp getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(java.sql.Timestamp transactionDate) {
		this.transactionDate = transactionDate;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

}
