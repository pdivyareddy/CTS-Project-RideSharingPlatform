package com.cognizant.ridesharingplatform.ridemanagement.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.Id;

@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "distances")
public class Distances {
	@Id
	@Column(name = "distanceid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int distanceId;

	@Column(name = "distancefrom")
	private String distancefrom;

	@Column(name = "distanceto")
	private String distanceTo;

	@Column(name = "distancesinkms")
	private int distanceInKms;

}
