package com.cognizant.ridesharingplatform.ridemanagement.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DistancesDto {
	private int distanceId;
	private String distanceFrom;
	private String distanceTo;
	private int DistanceInKms;

}
