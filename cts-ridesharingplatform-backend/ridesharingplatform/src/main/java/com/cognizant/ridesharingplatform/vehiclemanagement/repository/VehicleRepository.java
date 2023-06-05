package com.cognizant.ridesharingplatform.vehiclemanagement.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cognizant.ridesharingplatform.vehiclemanagement.model.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle, String> {

	Vehicle findByBelongsToUserId(int id);

	Vehicle findByRegistrationNo(String registrationNo);

	@Transactional
	@Modifying
	@Query("update Vehicle set inspectionStatus='approved' where registrationNo=:registrationNo")
	void approveVehicle(@Param("registrationNo") String registrationNo);

	@Transactional
	@Modifying
	@Query("update Vehicle set inspectionStatus='rejected' where registrationNo=:registrationNo")
	void rejectVehicle(@Param("registrationNo") String registrationNo);

	@Query("select v,vd from Vehicle v ,VehicleDetails vd where inspectionStatus='pending' and v.registrationNo=vd.registrationNo")
	List<Object[]> getApprovalPendingVehicles();

	@Transactional
	@Modifying
	void deleteByRegistrationNo(String registrationNo);

	List<Vehicle> findAllByBelongsToUserId(int userId);

}
