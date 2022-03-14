package com.rank.assesment.casino_backend.model;

import java.util.Date;

import javax.persistence.Column;  
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;  

@Entity  
@Table 
public class Transaction {
    
	@Id   
	@Column  
    private int id;

	@Column
	private Date timestamp;
	
	@Column
	private TransactionType actionType;

	@Column
	private double change;

	@ManyToOne
    @JoinColumn(name="PLAYER_ID", nullable=false)
    public PlayerData player;

	public Transaction() {

		this.id = 0;
		this.timestamp = new Date(0);
		this.actionType = TransactionType.NONE;
		this.change = 0.0;
	}

	public Transaction(int id, Date timestamp, TransactionType actionType, double change) {

		this.id = id;
		this.timestamp = timestamp;
		this.actionType = actionType;
		this.change = change;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
