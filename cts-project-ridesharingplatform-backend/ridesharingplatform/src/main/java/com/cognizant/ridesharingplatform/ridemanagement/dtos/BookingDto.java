package com.cognizant.ridesharingplatform.ridemanagement.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingDto {

	private int bookingId;

	private int bookedOn;

	private int riderUserid;

	private int noOfSeats;

	private int totalAmount;

	private String paymentMode;
	
	private int ridescheduleid;

}
