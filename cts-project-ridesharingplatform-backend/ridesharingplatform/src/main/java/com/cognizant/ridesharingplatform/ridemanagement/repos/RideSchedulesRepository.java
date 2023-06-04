package com.cognizant.ridesharingplatform.ridemanagement.repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.cognizant.ridesharingplatform.ridemanagement.entities.RideSchedules;

public interface RideSchedulesRepository extends CrudRepository<RideSchedules, Integer> {

	
	//c.Search a ride schedule by using from to and available seats
	List<RideSchedules> findRideByRideFromAndRideToAndRideFareLessThanEqualAndRideFareGreaterThanEqualAndNoOfSeatsAvailableGreaterThanEqual(String ridefrom,String rideto,int maxRideFare,int minRideFare,int availableSeats);

	RideSchedules findByVehicleRegistrationNo(String registrationNo);
}
