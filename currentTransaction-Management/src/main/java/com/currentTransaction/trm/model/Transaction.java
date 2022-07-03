package com.currentTransaction.trm.model;

import java.math.BigDecimal;
import java.util.Date;


public class Transaction {
	
	private int transactionId;
	private BigDecimal amount;
	private BigDecimal balance;
	private int accountId ;
	private int customerId;
	private String comment;
	
	
	//private Account account;
	
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Transaction(int transactionId,BigDecimal amount,BigDecimal balance,int accountId,int customerId, String comment) {
		this.transactionId= transactionId;
		this.accountId=accountId;
		this.customerId=customerId;
		this.amount = amount;
		this.balance= balance;
		this.comment= comment;
	}
	public Transaction() {
		// TODO Auto-generated constructor stub
	}
	public int getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public BigDecimal getBalance() {
		return balance;
	}
	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	
	
}
