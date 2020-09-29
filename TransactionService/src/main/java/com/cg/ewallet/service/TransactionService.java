package com.cg.ewallet.service;

import java.util.List;


import com.cg.ewallet.dto.Transaction;
import com.cg.ewallet.exception.UserNotFoundException;


public interface TransactionService {
	
	public List<Transaction> getAllTransaction();
	
	public Transaction getTransactionByPhnNumber(long phnNumber) throws UserNotFoundException;
	
	public String transferAmt(long phnNumber, long receiverPhnNumber, float amount) throws UserNotFoundException;
	
	//public List<Transaction> getBalanceOfCustomer(long phnNumber);
	
	public String getCustomerBalance(long phnNumber) throws UserNotFoundException;
	

}
