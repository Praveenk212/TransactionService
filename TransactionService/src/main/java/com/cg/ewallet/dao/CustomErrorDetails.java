package com.cg.ewallet.dao;

public class CustomErrorDetails {
	
	private String message;
	private String errorDetails;
	
	
	public CustomErrorDetails(String message, String errorDetails) {
		super();
		this.message = message;
		this.errorDetails = errorDetails;
	}
	
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getErrorDetails() {
		return errorDetails;
	}
	public void setErrorDetails(String errorDetails) {
		this.errorDetails = errorDetails;
	}
	
	

}
