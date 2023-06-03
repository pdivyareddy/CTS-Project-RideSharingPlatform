package com.cognizant.ridesharingplatform.ridemanagement.exceptions;

public class MaxSeatsPerRideExceededException extends Exception{
	
	private static final long serialVersionUID = 1L;
	private String message;
	public  MaxSeatsPerRideExceededException(){}
	public MaxSeatsPerRideExceededException(String message) {
		this.message=message;
	}
	public String getMessage() {
		return this.message;
	}
	}