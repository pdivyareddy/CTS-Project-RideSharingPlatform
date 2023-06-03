package com.cognizant.ridesharingplatform.ridemanagement.exceptions;



public class NoRideFoundException extends Exception {
	
	private static final long serialVersionUID = 1L;
	private String message;
	public  NoRideFoundException(){}
	public NoRideFoundException(String message) {
		this.message=message;
	}
	public String getMessage() {
		return this.message;
	}
	}