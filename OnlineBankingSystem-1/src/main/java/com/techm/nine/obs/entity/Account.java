package com.techm.nine.obs.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
public class Account {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long accountId;
	
	@Column(nullable = false)
	String accountNo;
	
	@Column(nullable = false)
	Double balance;
	
	@Column(nullable = false)
	String password;
	
	@Column(columnDefinition = "VARCHAR(255) DEFAULT 'savings'")
	String accountType;
	
	

	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

	@OneToMany(mappedBy = "id")
	List<TransactionHistory> transactionHistories;
	

	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Account(Long accountId, String accountNo, Double balance, String password, String accountType, User user,
			List<TransactionHistory> transactionHistories) {
		super();
		this.accountId = accountId;
		this.accountNo = accountNo;
		this.balance = balance;
		this.password = password;
		this.accountType = accountType;
		this.user = user;
		this.transactionHistories = transactionHistories;
	}

	public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<TransactionHistory> getTransactionHistories() {
		return transactionHistories;
	}

	public void setTransactionHistories(List<TransactionHistory> transactionHistories) {
		this.transactionHistories = transactionHistories;
	}

	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", accountNo=" + accountNo + ", balance=" + balance + ", password="
				+ password + ", accountType=" + accountType + ", user=" + user + ", transactionHistories="
				+ transactionHistories + "]";
	}
	
	
	
	
}
