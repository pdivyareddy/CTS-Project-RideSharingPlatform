package com.cognizant.ridesharingplatform.vehiclemanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cognizant.ridesharingplatform.vehiclemanagement.model.VehicleTypes;

public interface VehicleTypesRepository extends JpaRepository<VehicleTypes, Integer> {

	@Query("SELECT DISTINCT type FROM VehicleTypes")
	List<String> getVehicleTypes();

	VehicleTypes findByType(String type);

}
