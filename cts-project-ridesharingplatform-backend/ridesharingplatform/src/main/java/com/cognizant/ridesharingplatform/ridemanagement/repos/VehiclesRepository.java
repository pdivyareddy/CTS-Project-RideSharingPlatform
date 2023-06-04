package com.cognizant.ridesharingplatform.ridemanagement.repos;
import org.springframework.data.repository.CrudRepository;

import com.cognizant.ridesharingplatform.ridemanagement.entities.Vehicles;


public interface VehiclesRepository extends CrudRepository<Vehicles, String>{
	Vehicles findByRegistrationNo(String registrationNo);

}
