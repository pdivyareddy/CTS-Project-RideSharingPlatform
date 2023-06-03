package com.cognizant.ridesharingplatform.ridemanagement.dtos;


import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RideSchedulesDto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String rideFrom;
	private String rideTo;
	private LocalDate rideStartsOn;
	private LocalTime rideTime;
	private int rideFare;
	private String vehicleRegistrationNo;
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int motoristUserId;
	private int noOfSeatsAvailable;
	

}
