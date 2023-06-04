package com.cognizant.ridesharingplatform.ridemanagement.mapper;

import com.cognizant.ridesharingplatform.ridemanagement.dtos.RideSchedulesDto;
import com.cognizant.ridesharingplatform.ridemanagement.entities.RideSchedules;


public class RideSchedulesMapper {
	public static RideSchedulesDto rideschedulesToRideScheduleDto(RideSchedules rideSchedules) {
		
		RideSchedulesDto rideSchedulesDto=new RideSchedulesDto(
				rideSchedules.getId(),
				rideSchedules.getRideFrom(),
				rideSchedules.getRideTo(),
				rideSchedules.getRideStartsOn(),
				rideSchedules.getRideTime(),
				rideSchedules.getRideFare(),
				rideSchedules.getVehicleRegistrationNo(),
				rideSchedules.getMotoristUserId(),
				rideSchedules.getNoOfSeatsAvailable()
				);
		return rideSchedulesDto;
	}
public static RideSchedules rideschedulesDtoToRideSchedule(RideSchedulesDto rideSchedulesDto) {
		
		RideSchedules rideSchedules=new RideSchedules(
				rideSchedulesDto.getId(),
				rideSchedulesDto.getRideFrom(),
				rideSchedulesDto.getRideTo(),
				rideSchedulesDto.getRideStartsOn(),
				rideSchedulesDto.getRideTime(),
				rideSchedulesDto.getRideFare(),
				rideSchedulesDto.getVehicleRegistrationNo(),
				rideSchedulesDto.getMotoristUserId(),
				rideSchedulesDto.getNoOfSeatsAvailable()
				);
		return rideSchedules;
	}
	
	
	
		
	

}
