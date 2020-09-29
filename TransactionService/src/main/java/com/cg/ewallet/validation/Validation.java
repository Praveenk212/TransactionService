package com.cg.ewallet.validation;

import org.springframework.stereotype.Repository;

@Repository
public class Validation {

	public boolean checkCustomerMobile(String phnNumber)
	{
		String regex="(0/91)?[7-9][0-9]{9}";
		return phnNumber.matches(regex);
	}


	public boolean isDigit(String id)
	{
		String regex = "[1-9][0-9]*|0";
		return id.matches(regex);
	}


	public boolean checkBalance(String balance)
	{
		String regex ="^[0-9]{1,15}$";
		return balance.matches(regex);
	}

}
