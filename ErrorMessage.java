package com.simactivation.Error;

public class ErrorMessage {

	private int statusCode;
	private String message;
	
	public ErrorMessage(){
		
	}
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}
