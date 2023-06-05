package com.cognizant.ridesharingplatform.ridemanagement.exceptions;

public class BadSearchCriteriaException extends Exception {
	private static final long serialVersionUID = 1L;
	private String message;
	public  BadSearchCriteriaException(){}
	public BadSearchCriteriaException(String message) {
		this.message=message;
	}
	public String getMessage() {
		return this.message;
	}
}
