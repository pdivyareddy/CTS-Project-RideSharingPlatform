package com.cognizant.ridesharingplatform.vehiclemanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.ridesharingplatform.vehiclemanagement.model.VehicleDetails;

public interface VehicleDetailsRepository extends JpaRepository<VehicleDetails, String> {

}
