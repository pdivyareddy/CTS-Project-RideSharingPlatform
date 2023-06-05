package com.cognizant.ridesharingplatform.ridemanagement.exceptions;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;







@ControllerAdvice
public class GlobalExceptionHandler {
	@Value(value="${message1}")
	private String message1;
	@Value(value="${message2}")
	private String message2;
	@Value(value="${message3}")
	private String message3;
	@Value(value="${message4}")
	private String message4;
	@Value(value="${message5}")
	private String message5;
	@Value(value="${message6}")
	private String message6;
	@Value(value="${message7}")
	private String message7;
	@Value(value="${message8}")
	private String message8;

	@ExceptionHandler(value=BookingNotFoundException.class)
	public ResponseEntity<String> bookingNotFoundException(BookingNotFoundException ex) {
		return new ResponseEntity<String>(message1,HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(value=BookingAlreadyExistException.class)
	public ResponseEntity<String>  employeeyAlreadyExistsException(BookingAlreadyExistException ex) {
		return new ResponseEntity<String>(message2,HttpStatus.CONFLICT);
	}
	@ExceptionHandler(value=MaxSeatsPerRideExceededException.class)
	public ResponseEntity<String>  MaxSeatsPerRideExceededException(MaxSeatsPerRideExceededException ex) {
		return new ResponseEntity<String>(message3,HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(value=VehicleNotApprovedException.class)
	public ResponseEntity<String>  VehicleNotApprovedException(VehicleNotApprovedException ex) {
		return new ResponseEntity<String>(message4,HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(value=MaximumCapacityExceededException.class)
	public ResponseEntity<String>  MaximumCapacityExceededException(MaximumCapacityExceededException ex) {
		return new ResponseEntity<String>(message5,HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(NoRideFoundException.class)
	public ResponseEntity<String> handleNoRideFoundException(NoRideFoundException ex){
		return new ResponseEntity<String>(message6,HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(value=BadSearchCriteriaException.class)
	public ResponseEntity<String>  BadSearchCriteriaException(BadSearchCriteriaException ex) {
		return new ResponseEntity<String>(message7,HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(value=NoVehicleFoundException.class)
	public ResponseEntity<String>  NoVehicleFoundException(NoVehicleFoundException ex) {
		return ResponseEntity.internalServerError().body(ex.getMessage());
	}
	
	
}
