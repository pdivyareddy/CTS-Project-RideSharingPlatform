package com.cognizant.ridesharingplatform.ridemanagement.services;

import java.util.List;

import com.cognizant.ridesharingplatform.ridemanagement.dtos.DistancesDto;
import com.cognizant.ridesharingplatform.ridemanagement.dtos.FareParametersDto;
import com.cognizant.ridesharingplatform.ridemanagement.dtos.RideSchedulesDto;
import com.cognizant.ridesharingplatform.ridemanagement.dtos.SearchCriteriaDto;
import com.cognizant.ridesharingplatform.ridemanagement.entities.Bookings;
import com.cognizant.ridesharingplatform.ridemanagement.exceptions.BadSearchCriteriaException;
import com.cognizant.ridesharingplatform.ridemanagement.exceptions.BookingAlreadyExistException;
import com.cognizant.ridesharingplatform.ridemanagement.exceptions.MaxSeatsPerRideExceededException;
import com.cognizant.ridesharingplatform.ridemanagement.exceptions.MaximumCapacityExceededException;
import com.cognizant.ridesharingplatform.ridemanagement.exceptions.NoRideFoundException;
import com.cognizant.ridesharingplatform.ridemanagement.exceptions.NoVehicleFoundException;
import com.cognizant.ridesharingplatform.ridemanagement.exceptions.VehicleNotApprovedException;

public interface RideService {
	
	
	List<DistancesDto> getAllDistances();
	
	int calculateFare(FareParametersDto fareParametersDto) throws NoRideFoundException;
	
	RideSchedulesDto createRide(RideSchedulesDto rideSchedulesDto) throws VehicleNotApprovedException,MaximumCapacityExceededException,NoVehicleFoundException;

	List<RideSchedulesDto> searchRideSchedule(SearchCriteriaDto searchCriteria)throws BadSearchCriteriaException,NoRideFoundException ;
	
	Bookings createBooking(Bookings bookings)throws BookingAlreadyExistException,MaxSeatsPerRideExceededException;



	
	
	//List<Bookings> searchBookingByRiderUserId(int riderUserId)throws BookingNotFoundException;
	//List<RideSchedules> getAllRideSchedules();
	//List<Vehicles> getAllVehicles();


}
