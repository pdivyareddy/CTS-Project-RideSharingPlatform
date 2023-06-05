package com.cognizant.ridesharingplatform.vehiclemanagement.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;

import com.cognizant.ridesharingplatform.vehiclemanagement.dto.VehicleDTO;
import com.cognizant.ridesharingplatform.vehiclemanagement.dto.VehicleTypesDTO;
import com.cognizant.ridesharingplatform.vehiclemanagement.exceptions.CustomException;
import com.cognizant.ridesharingplatform.vehiclemanagement.model.Vehicle;

public interface VehicleService {

	public List<String> getVehicleTypes();

	public List<VehicleTypesDTO> getAllVehicleTypesDetails();

	public ResponseEntity<String> addVehicle(Vehicle vehicle);

	public boolean deleteVehicle(String registrationNo) throws CustomException;

	public Vehicle getVehicleByUserId(int userId) throws CustomException;

	public List<VehicleDTO> getVehicleDTOByUserId(int userId) throws CustomException;

	public ArrayList<VehicleDTO> getApprovalPendingVehicles();

	public boolean approveVehicle(String registrationNo);

	public boolean rejectVehicle(String registrationNo);

	public Vehicle getSingleVehiclePageWise(int pageno) throws CustomException;

	public Vehicle getVehicleByRegistrationNo(String registrationNo) throws CustomException;
}
