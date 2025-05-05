package com.cg.ewallet.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.ewallet.dao.AccountRepository;
import com.cg.ewallet.dao.TransactionRepository;
import com.cg.ewallet.dto.Account;
import com.cg.ewallet.dto.Transaction;
import com.cg.ewallet.exception.UserNotFoundException;

@Service
public class TransactionServiceImpl implements TransactionService {
	
	@Autowired(required=true)
	TransactionRepository transDao;
	
	@Autowired(required=true)
	AccountRepository accDao;
	
	 @Override
		public List<Transaction> getAllTransaction() {
		
			return transDao.findAll();
		}
	 
	 
	 @Override 
	 public Transaction getTransactionByPhnNumber(long phnNumber) throws UserNotFoundException
	  {
	
		 Transaction transaction=null;
		  List<Transaction> allTranstList = transDao.findAll();
		  
		  for(Transaction transDto:allTranstList) {
			  if(transDto.getPhnNumber()== phnNumber) {
				  transaction = transDto; 
				  break;
			  }}
		  if(transaction==null) {
			  throw new UserNotFoundException("User with "+phnNumber+" Not Found");
		  }
		  
		  return transaction;  
	  }
	 

	 @Override
	 public String transferAmt(long phnNumber, long receiverPhnNumber, float amount) throws UserNotFoundException{
		
		 List<Account> allAccountList = accDao.findAll();
		 String transferResult="";
		 int flag =0;
		 boolean accountExist=false;
		 boolean sameAccount=false;
		 for(Account accDto:allAccountList)
		 {
			 if(accDto.getPhnNumber()== phnNumber) {
				 flag=1;
			 }
			 if(flag==0) {
				 throw new UserNotFoundException("User with "+phnNumber+" Not Found");
			 }
			 if(accDto.getPhnNumber() == phnNumber && accDto.getPhnNumber()==receiverPhnNumber)
			 {
				 sameAccount=true;
			 }
		 }
		 for(Account accDto:allAccountList)
		 {
			 if(accDto.getPhnNumber() == receiverPhnNumber)
			 {
				 accountExist=true;
			 }
		 }
		 if(sameAccount)
		 {
			 transferResult+="Oops can't Transfer as sender and receiver Number is same ";
		 }
		 else
		 {
			 if(accountExist)
			 {
				
				 long transactionId=(long)(Math.floor(Math.random()*100000)+1);
				 for(Account accDto:allAccountList)
				 {
					 if(accDto.getPhnNumber()==phnNumber)
					 {
						 if(accDto.getBalance()>=amount)
						 {
							
							 Transaction tranDto=new Transaction();
							 float amountLeft=(accDto.getBalance()-amount);
							 accDto.setBalance(amountLeft);
							 tranDto.setAmtTransfer(amount);
							 tranDto.setBalance(amountLeft);
							 tranDto.setPhnNumber(accDto.getPhnNumber());
							 tranDto.setDateoftransfer(LocalDate.now());
						
							 tranDto.setTransactionId(transactionId);

							 accDao.saveAndFlush(accDto);
							 transDao.saveAndFlush(tranDto);
				

							 transferResult+=" Amount "+amount+" 	Transfered to "+receiverPhnNumber;

							 for(Account accDto1:allAccountList)
							 {
								
								 if(accDto1.getPhnNumber()==receiverPhnNumber)
								 {
									 Transaction tranDto1=new Transaction();
									 float Totalamount=(accDto1.getBalance()+amount);
									 accDto1.setBalance(Totalamount);
									 tranDto1.setAmtReceived(amount);
									 tranDto1.setBalance(Totalamount);
									 tranDto1.setPhnNumber(accDto1.getPhnNumber());
								
									 tranDto1.setTransactionId((transactionId+1));	
									 tranDto1.setDateoftransfer(LocalDate.now());									
									 accDao.saveAndFlush(accDto1);
									 transDao.saveAndFlush(tranDto1);							
								 }
							 }
						 }
						 else
						 {
							 transferResult+="Oops can't Transfer as amount is not sufficient ";
						 }
					 }
				 }
			 }
			 else 
			 {
				 throw new UserNotFoundException("User with "+receiverPhnNumber+" Not Found");
			 }
		 }
		 return transferResult;		
	 }


	@Override
	public String getCustomerBalance(long phnNumber)  throws UserNotFoundException{
		String balance="";
		int flag=0;
		  List<Transaction> allTranstList = transDao.findAll();
		  
		  for(Transaction transDto:allTranstList) {
			  if(transDto.getPhnNumber()== phnNumber) {
				  flag=1;
				 balance = "Balane Of phn Number is : "+transDto.getBalance();
			  }}
		  if(flag==0){
				  throw new UserNotFoundException("User Not Found");
			  }
		  
		  return balance; 
		
	}

		
		

}
