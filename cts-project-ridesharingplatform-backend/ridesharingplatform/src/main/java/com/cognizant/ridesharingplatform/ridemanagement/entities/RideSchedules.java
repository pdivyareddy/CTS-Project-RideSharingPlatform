package com.cognizant.ridesharingplatform.ridemanagement.entities;

import java.time.LocalDate;
import java.time.LocalTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.AssertFalse;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "rideschedules")
public class RideSchedules {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@NotNull
	@Column(name = "ridefrom")
	private String rideFrom;

	@NotNull
	@Column(name = "rideto")
	private String rideTo;

	@AssertFalse(message = "From and To should not be same for a given route")
	private boolean isFromEqualsTo() {
		return rideFrom != null && rideFrom.equalsIgnoreCase(rideTo);
	}

	@NotNull
	@FutureOrPresent(message = "Date can't be the past date")
	@Column(name = "ridestartson")
	private LocalDate rideStartsOn;

	@NotNull
	@FutureOrPresent(message = "Time can't be the past time")
	@Column(name = "ridetime")
	private LocalTime rideTime;

	@NotNull
	@Column(name = "ridefare")
	private int rideFare;

	@NotNull
	@Column(name = "vehicleregistrationno")
	@Size(min = 10, max = 10, message = "Vehicle registration number must be exactly 10 characters long")
	private String vehicleRegistrationNo;

	@NotNull
	@Column(name = "motoristuserid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int motoristUserId;

	@NotNull
	@Column(name = "noofseatsavailable")
	private int noOfSeatsAvailable;

}
