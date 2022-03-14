package com.rank.assesment.casino_backend.model;

import java.util.ArrayList;
import java.util.List;

public class PlayerDataDTO {

	private String name;
	private double balance;
    private List<TransactionDTO> transactionlist;
	
	public PlayerDataDTO() {

		this.name = "";
		this.balance = 0.0;
		this.transactionlist = new ArrayList<TransactionDTO>();
	}

	public PlayerDataDTO(String name, double balance, List<TransactionDTO> transactionlist) {

		this.name = name;
		this.balance = balance;
		this.transactionlist = transactionlist;
	}

	public PlayerDataDTO(PlayerData srcData) {

		this.name = srcData.getName();
		this.balance = srcData.getBalance();
		this.transactionlist = new ArrayList<TransactionDTO>();
		srcData.getTransactionlist().forEach(trans -> this.transactionlist.add(new TransactionDTO(trans)));
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

	public List<TransactionDTO> getTransactionlist() {
		return transactionlist;
	}

	public void setTransactionlist(List<TransactionDTO> transactionlist) {
		this.transactionlist = transactionlist;
	} 

	
}
