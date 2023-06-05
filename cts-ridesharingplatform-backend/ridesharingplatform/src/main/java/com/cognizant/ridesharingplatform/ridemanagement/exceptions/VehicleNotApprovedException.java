package com.cognizant.ridesharingplatform.ridemanagement.exceptions;

public class VehicleNotApprovedException extends Exception{
	
	private static final long serialVersionUID = 1L;
	private String message;
	public  VehicleNotApprovedException(){}
	public VehicleNotApprovedException(String message) {
		this.message=message;
	}
	public String getMessage() {
		return this.message;
	}
	}
