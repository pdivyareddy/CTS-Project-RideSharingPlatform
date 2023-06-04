package com.cognizant.ridesharingplatform.ridemanagement.exceptions;

public class BookingNotFoundException extends Exception{
	
	private static final long serialVersionUID = 1L;
	private String message;
	public  BookingNotFoundException(){}
	public BookingNotFoundException(String message) {
		this.message=message;
	}
	public String getMessage() {
		return this.message;
	}
	}


