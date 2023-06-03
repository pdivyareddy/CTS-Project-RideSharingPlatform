package com.cognizant.ridesharingplatform.ridemanagement.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.ridesharingplatform.ridemanagement.entities.Distances;

public interface DistancesRepository extends JpaRepository<Distances,Integer> {

	Distances findDistanceInKmsBydistancefromAndDistanceTo(String distancefrom,String distanceto);

}
