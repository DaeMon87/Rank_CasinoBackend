package com.rank.assesment.casino_backend.model;

public class TransactionCommunication {
    
    private int id;

	private int transactionid;

	private double changeValue;

	private String promoCode;

	public TransactionCommunication() {
		this.id = 0;
		this.transactionid = 0;
		this.changeValue = 0.0;
		this.promoCode = "";
	}

	public TransactionCommunication(int id, int transactionid, double changeValue, String promoCode) {
		this.id = id;
		this.transactionid = transactionid;
		this.changeValue = changeValue;
		this.promoCode = promoCode;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getChangeValue() {
		return changeValue;
	}

	public void setChangeValue(double changeValue) {
		this.changeValue = changeValue;
	}

	public int getTransactionid() {
		return transactionid;
	}

	public void setTransactionid(int transactionid) {
		this.transactionid = transactionid;
	}

	public String getPromoCode() {
		return promoCode;
	}

	public void setPromoCode(String promoCode) {
		this.promoCode = promoCode;
	}
}
