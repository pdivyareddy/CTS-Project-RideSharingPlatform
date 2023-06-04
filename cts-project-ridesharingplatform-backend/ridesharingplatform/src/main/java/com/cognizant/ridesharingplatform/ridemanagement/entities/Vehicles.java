package com.cognizant.ridesharingplatform.ridemanagement.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

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
@Table(name = "vehicles")
public class Vehicles {

	@Id
	@Column(name = "vehicletypeid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int vehicleTypeId;

	@Column(name = "registrationno", length = 10)
	private String registrationNo;

	@NotNull
	@Pattern(regexp = "^(pending|approved|rejected)$")
	@Column(name = "inspectionstatus")
	private String inspectionStatus;

	@Column(name = "vehicletype")
	private String vehicleType;

	@Column(name = "maxseats")
	private int maxSeats;

	@Column(name = "fareperkm")
	private int farePerKm;

}
