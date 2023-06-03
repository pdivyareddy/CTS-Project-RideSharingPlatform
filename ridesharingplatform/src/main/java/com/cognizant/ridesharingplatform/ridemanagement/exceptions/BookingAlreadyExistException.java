package com.cognizant.ridesharingplatform.ridemanagement.exceptions;

public class BookingAlreadyExistException extends Exception{
	
	private static final long serialVersionUID = 1L;
	private String message;
	public  BookingAlreadyExistException(){}
	public BookingAlreadyExistException(String message) {
		this.message=message;
	}
	public String getMessage() {
		return this.message;
	}
	}


