package com.cognizant.ridesharingplatform.ridemanagement.exceptions;

public class MaximumCapacityExceededException extends Exception{
	
	private static final long serialVersionUID = 1L;
	private String message;
	public  MaximumCapacityExceededException(){}
	public MaximumCapacityExceededException(String message) {
		this.message=message;
	}
	public String getMessage() {
		return this.message;
	}
	}