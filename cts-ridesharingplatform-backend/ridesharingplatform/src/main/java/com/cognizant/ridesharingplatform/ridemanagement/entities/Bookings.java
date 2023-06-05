package com.cognizant.ridesharingplatform.ridemanagement.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;

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
@Table(name = "bookings")
public class Bookings {
	@Id
	@Column(name = "bookingid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bookingId;

	@Column(name = "bookedon")
	private int bookedOn;

	@Column(name = "rideruserid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int riderUserId;

	@Max(value = 2, message = "Each users cannot book more than 2 seats")
	@Column(name = "noofseats")
	private int noOfSeats;

	@Column(name = "totalamount")
	private int totalAmount;

	@Column(name = "paymentmode")
	private String paymentMode;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ridescheduleid", referencedColumnName = "id")
	private RideSchedules rideschedeules;

}
