package com.cg.ewallet.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="account")
public class Account {
	
	@Id
	@Column(name="phnnumber")
	private long phnNumber;
	@Column(name="accno")
	private long accNo;
	@Column(name="balance")
	private float balance;
	
	
	
	//Getter and Setter Methods
	
	
	public long getAccNo() {
		return accNo;
	}
	public void setAccNo(long accNo) {
		this.accNo = accNo;
	}
	public float getBalance() {
		return balance;
	}
	public void setBalance(float balance) {
		this.balance = balance;
	}
	
	
	public long getPhnNumber() {
		return phnNumber;
	}
	public void setPhnNumber(long phnNumber) {
		this.phnNumber = phnNumber;
	}
	//Constructor
	public Account() {
		super();
	}
	
	
	
	public Account(long phnNumber, long accNo, float balance) {
		super();
		
		this.accNo = accNo;
		this.balance = balance;
		this.phnNumber = phnNumber;
	}
	
	
	//toString 
	@Override
	public String toString() {
		return "Account [phnNumber=" + phnNumber + ", accNo=" + accNo + ", balance=" + balance +  "]";
	}
	
	
	

}
