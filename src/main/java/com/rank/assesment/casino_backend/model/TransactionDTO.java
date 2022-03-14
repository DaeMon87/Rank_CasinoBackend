package com.rank.assesment.casino_backend.model;

import java.util.Date;  

public class TransactionDTO {

	private Date timestamp;
	private TransactionType actionType;
	private double change;

	public TransactionDTO() {

		this.timestamp = new Date(0);
		this.actionType = TransactionType.NONE;
		this.change = 0.0;
	}

	public TransactionDTO(Date timestamp, TransactionType actionType, double change) {

		this.timestamp = timestamp;
		this.actionType = actionType;
		this.change = change;
	}

	public TransactionDTO(Transaction srcData) {

		this.timestamp = srcData.getTimestamp();
		this.actionType = srcData.getActionType();
		this.change = srcData.getChange();
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public TransactionType getActionType() {
		return actionType;
	}

	public void setActionType(TransactionType actionType) {
		this.actionType = actionType;
	}

	public double getChange() {
		return change;
	}

	public void setChange(double change) {
		this.change = change;
	}
}
