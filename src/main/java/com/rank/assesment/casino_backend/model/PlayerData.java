package com.rank.assesment.casino_backend.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;  
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;  

@Entity  
@Table 
public class PlayerData {
    
	@Id   
	@Column  
    private int id;

	@Column
	private String name;

	@Column
	private double balance;

	@Column
	private int freeGameCount;

	@OneToMany(mappedBy="player", targetEntity=Transaction.class)
    private List<Transaction> transactionlist; 

	public PlayerData() {
		this.id = 0;
		this.name = "";
		this.balance = 0.0;
		this.freeGameCount = 0;
	}

	public PlayerData(int id, String name, double balance, int freeGameCount) {
		this.id = id;
		this.name = name;
		this.balance = balance;
		this.freeGameCount = freeGameCount;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public List<Transaction> getTransactionlist() {
		return transactionlist;
	}

	public void setTransactionlist(List<Transaction> transactionlist) {
		this.transactionlist = transactionlist;
	}

	public int getFreeGameCount() {
		return freeGameCount;
	}

	public void setFreeGameCount(int freeGameCount) {
		this.freeGameCount = freeGameCount;
	}

	public void addTransaction(Transaction transaction) {

		this.transactionlist.add(transaction);
		transaction.getActionType().ApplyChange(this, transaction.getChange());
	}

	public void ApplyChange(TransactionCommunication change, TransactionType type)
	{
		assert(change.getChangeValue() > 0);
		if(type == TransactionType.WAGER && change.getPromoCode() == "paper")
		{
			freeGameCount += 5;
		}
		addTransaction(new Transaction(change.getId(), new Date(), type, change.getChangeValue()));
	}
}
