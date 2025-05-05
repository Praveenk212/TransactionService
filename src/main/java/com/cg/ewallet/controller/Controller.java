 package com.cg.ewallet.controller;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.ewallet.dto.Transaction;
import com.cg.ewallet.exception.UserNotFoundException;
import com.cg.ewallet.service.TransactionService;


@RestController
@RequestMapping(value="/")
public class Controller {
	
	@Autowired(required=true)
	TransactionService transService;
	
	Logger log=LoggerFactory.getLogger(Controller.class);
	
	@GetMapping("/")
	public String Home()
	{
		return  "Home Page For Transaction Service";
	}
	
	
	
	
	@GetMapping("/view-customer-transaction/{phnNumber}")
	public ResponseEntity<Transaction> getTransactionByPhnNumber(@PathVariable long phnNumber)throws UserNotFoundException{
		
		Transaction transaction=null;
		
		try {
			transaction = transService.getTransactionByPhnNumber(phnNumber);
		}catch(UserNotFoundException e){
			 throw new UserNotFoundException("User with "+phnNumber+" Does not Exist");
		}
		
		log.info("Getting information of transaction specific cutomer by MobileNumber ");
		if(HttpStatus.BAD_REQUEST==null) {
			log.warn("Bad Request");
		}
		
		return new ResponseEntity<>(transaction,HttpStatus.OK);
	}
	
	
	
	
	
	@GetMapping("/transaction-list")
	public ResponseEntity<List<Transaction>> getAllTransaction(){
		log.info("Transaction List");
		List<Transaction> tranList=transService.getAllTransaction();
		return new ResponseEntity<>(tranList,HttpStatus.OK);
	}
	
	
	
	
	
	
	@GetMapping("/transfer-money/{phnNumber}/{receiverPhnNumber}/{amount}")
	public String transferAmt(@PathVariable long phnNumber,@PathVariable long receiverPhnNumber,@PathVariable float amount) throws UserNotFoundException{
		log.info("Transfer money Customer function");
		return transService.transferAmt(phnNumber, receiverPhnNumber, amount);
	}
	
	@GetMapping("/view-customer-balance/{phnNumber}")
	public String getCustomerBalance(@PathVariable long phnNumber) throws UserNotFoundException {
		log.info("View Balance OF Customer");
		return transService.getCustomerBalance(phnNumber);
		
	}
	

	
	

}
