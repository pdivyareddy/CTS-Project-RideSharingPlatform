package com.cognizant.ridesharingplatform.ridemanagement.mapper;

import com.cognizant.ridesharingplatform.ridemanagement.dtos.DistancesDto;
import com.cognizant.ridesharingplatform.ridemanagement.entities.Distances;


public class DistancesMapper {
public static DistancesDto distancesToDistancesDto(Distances distances) {
		
		DistancesDto distancesDto=new DistancesDto(
				distances.getDistanceId(),
				distances.getDistancefrom(),
				distances.getDistanceTo(),
				distances.getDistanceInKms()
				);
		return distancesDto;
		
	}
public static Distances distancesDtoToDistances(DistancesDto distancesDto) {
	Distances distances=new Distances(
			distancesDto.getDistanceId(),
			distancesDto.getDistanceFrom(),
			distancesDto.getDistanceTo(),
			distancesDto.getDistanceInKms()
			);
	return distances;
}

}
