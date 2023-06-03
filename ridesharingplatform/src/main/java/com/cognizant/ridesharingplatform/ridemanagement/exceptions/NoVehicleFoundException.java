package com.cognizant.ridesharingplatform.ridemanagement.exceptions;

public class NoVehicleFoundException extends Exception{
	private static final long serialVersionUID = 1L;
	private String message;
	public  NoVehicleFoundException(){}
	public NoVehicleFoundException(String message) {
		this.message=message;
	}
	public String getMessage() {
		return this.message;
	}
	}

