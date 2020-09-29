package com.cg.ewallet.dto;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="transaction")
public class Transaction {
	
	@Id
	@Column(name="transactionid")
	private long transactionId;
	@Column(name="phnnumber")
	private long phnNumber;
	@Column(name="amttransfer")
	private float amtTransfer;
	@Column(name="balance")
	private float balance;
	@Column(name="dateoftransfer")
	private LocalDate dateoftransfer;
	@Column(name="amtreceived")
	private float amtReceived;
	@Column(name="receiveraccountnumber")
	private long receiverAccNumber;
	@Column(name="senderaccountnumber")
	private long senderAccNumber;
	@Column(name="senderphnnumber")
	private long senderPhnNumber;
	@Column(name="receiverphnnumber")
	private long receiverPhnNumber;
	
	
	//Constructor
	public Transaction() {
		super();
	}
	
	
	public Transaction(long transactionId, long phnNumber, float amtTransfer, float balance, LocalDate dateoftransfer,
			float amtReceived, long receiverAccNumber, long senderAccNumber, long senderPhnNumber,
			long receiverPhnNumber) {
		super();
		this.transactionId = transactionId;
		this.phnNumber = phnNumber;
		this.amtTransfer = amtTransfer;
		this.balance = balance;
		this.dateoftransfer = dateoftransfer;
		this.amtReceived = amtReceived;
		this.receiverAccNumber = receiverAccNumber;
		this.senderAccNumber = senderAccNumber;
		this.senderPhnNumber = senderPhnNumber;
		this.receiverPhnNumber = receiverPhnNumber;
	}


	//getter and setter methods


	public long getTransactionId() {
		return transactionId;
	}


	public void setTransactionId(long transactionId) {
		this.transactionId = transactionId;
	}


	


	public long getPhnNumber() {
		return phnNumber;
	}


	public void setPhnNumber(long phnNumber) {
		this.phnNumber = phnNumber;
	}


	public float getAmtTransfer() {
		return amtTransfer;
	}


	public void setAmtTransfer(float amtTransfer) {
		this.amtTransfer = amtTransfer;
	}


	public float getAmtReceived() {
		return amtReceived;
	}


	public void setAmtReceived(float amtReceived) {
		this.amtReceived = amtReceived;
	}


	public LocalDate getDateoftransfer() {
		return dateoftransfer;
	}


	public void setDateoftransfer(LocalDate dateoftransfer) {
		this.dateoftransfer = dateoftransfer;
	}


	public long getSenderAccNumber() {
		return senderAccNumber;
	}


	public void setSenderAccNumber(long senderAccNumber) {
		this.senderAccNumber = senderAccNumber;
	}


	public long getReceiverAccNumber() {
		return receiverAccNumber;
	}


	public void setReceiverAccNumber(long receiverAccNumber) {
		this.receiverAccNumber = receiverAccNumber;
	}


	public long getSenderPhnNumber() {
		return senderPhnNumber;
	}


	public void setSenderPhnNumber(long senderPhnNumber) {
		this.senderPhnNumber = senderPhnNumber;
	}


	public long getReceiverPhnNumber() {
		return receiverPhnNumber;
	}


	public void setReceiverPhnNumber(long receiverPhnNumber) {
		this.receiverPhnNumber = receiverPhnNumber;
	}
	public float getBalance() {
		return balance;
	}


	public void setBalance(float balance) {
		this.balance = balance;
	}


	

	//toString
	@Override
	public String toString() {
		return "Transaction [transactionId=" + transactionId + ", phnNumber=" + phnNumber + ", amtTransfer=" + amtTransfer
				+ ", balance=" + balance + ", dateoftransfer=" + dateoftransfer + ", amtReceived=" + amtReceived
				+ ", receiverAccNumber=" + receiverAccNumber + ", senderAccNumber=" + senderAccNumber
				+ ", senderPhnNumber=" + senderPhnNumber + ", receiverPhnNumber=" + receiverPhnNumber + "]";
	}

	
	
	
	
	
	
	

}
