package com.cognizant.ridesharingplatform.vehiclemanagement.controllers;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.ridesharingplatform.vehiclemanagement.dto.VehicleDTO;
import com.cognizant.ridesharingplatform.vehiclemanagement.dto.VehicleTypesDTO;
import com.cognizant.ridesharingplatform.vehiclemanagement.exceptions.CustomException;
import com.cognizant.ridesharingplatform.vehiclemanagement.model.Vehicle;
import com.cognizant.ridesharingplatform.vehiclemanagement.model.VehicleDetails;
import com.cognizant.ridesharingplatform.vehiclemanagement.model.VehicleTypes;
import com.cognizant.ridesharingplatform.vehiclemanagement.service.VehicleServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class VehicleManagementApplicationController implements ErrorController {

	@Autowired
	VehicleServiceImpl vehicleServiceImpl;

	@GetMapping("/api/vehicles/vehicletypes")
	public List<VehicleTypesDTO> getVehicleTypes() throws CustomException {
		List<VehicleTypesDTO> allVehicleTypes = vehicleServiceImpl.getAllVehicleTypesDetails();
		if (allVehicleTypes.size() == 0) {
			throw new CustomException("No vehicle types exist");
		}
		return allVehicleTypes;
	}

	@PostMapping("/api/vehicles/addvehicle")
	public ResponseEntity<String> addNewVehicle(@RequestBody String jsonData)
			throws JsonMappingException, JsonProcessingException, CustomException {
		JSONObject jsnobject = new JSONObject(jsonData);
		JSONObject vehicleJson = jsnobject.getJSONObject("vehicle");
		JSONObject vehicleDetailsJson = jsnobject.getJSONObject("vehicledetails");
		JSONObject vehicleTypesJson = jsnobject.getJSONObject("vehicletypes");

		ObjectMapper objectMapper = new ObjectMapper();

		Vehicle vehicle = objectMapper.readValue(vehicleJson.toString(), Vehicle.class);
		VehicleDetails vehicleDetails = objectMapper.readValue(vehicleDetailsJson.toString(), VehicleDetails.class);
		VehicleTypes vehicleTypes = objectMapper.readValue(vehicleTypesJson.toString(), VehicleTypes.class);

		vehicle.setVehicleDetails(vehicleDetails);
		vehicle.setVehicleTypes(vehicleTypes);

		Vehicle vehicle2 = vehicleServiceImpl.getVehicleByRegistrationNo(vehicle.getRegistrationNo());
		if (vehicle2 != null) {
			return ResponseEntity.status(HttpStatus.OK)
					.body("vehicle already exists with registration no:" + vehicle.getRegistrationNo());
		}

		ResponseEntity<String> isVehicleAdded = vehicleServiceImpl.addVehicle(vehicle);

		if (isVehicleAdded.equals(ResponseEntity.status(HttpStatus.OK).body("vehicle added")))
			return ResponseEntity.status(HttpStatus.OK)
					.body("vehicle added with registration no:" + vehicle.getRegistrationNo());
		else
			return ResponseEntity.status(HttpStatus.OK).body("vehicle with registration no:"
					+ vehicle.getRegistrationNo() + " not added. " + isVehicleAdded.getBody());
	}

	@DeleteMapping("/api/vehicles/delete/{vehicleid}/{userid}")
	public ResponseEntity<String> deleteVehicle(@PathVariable String vehicleid, @PathVariable int userid)
			throws CustomException {
		Vehicle vehicle = vehicleServiceImpl.getVehicleByRegistrationNo(vehicleid);
		if (vehicle == null)
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body("no vehicle found with registrationNo:" + vehicleid);
		if (vehicle.getBelongsToUserId() == userid) {
			vehicleServiceImpl.deleteVehicle(vehicleid);
			return ResponseEntity.status(HttpStatus.OK).body("vehicle deleted with registration no:" + vehicleid);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("user id mismatch");
		}
	}

	@GetMapping("/api/vehicle/{userid}")
	public List<VehicleDTO> getVehicleByUserId(@PathVariable int userid) throws CustomException {
		List<VehicleDTO> vehicleDto = vehicleServiceImpl.getVehicleDTOByUserId(userid);
		return vehicleDto;
	}

	@GetMapping("/api/vehicles/pendingapprovals/{pageno}")
	public VehicleDTO pendingApprovals(@PathVariable int pageno) throws CustomException {
		ArrayList<VehicleDTO> al = vehicleServiceImpl.getApprovalPendingVehicles();
		if (al.size() == 0)
			throw new CustomException("No pending approval vehicles exist");
		VehicleDTO vehicleDTO = null;
		try {
			vehicleDTO = al.get(pageno - 1);
		} catch (IndexOutOfBoundsException ex) {
			throw new CustomException("IndexOutOfBoundsException -> no vehicle at page:" + pageno);
		}
		return vehicleDTO;
	}

	@PutMapping("/api/vehicles/approveorreject")
	public ResponseEntity<String> approveOrRejectVehicle(@RequestBody String jsonData) throws CustomException {
		JSONObject jsnobject = new JSONObject(jsonData);
		String vehicleid = jsnobject.getString("registrationNo");
		String status = jsnobject.getString("status");
		vehicleServiceImpl.getVehicleByRegistrationNo(vehicleid);
		if (status.equals("approve")) {
			vehicleServiceImpl.approveVehicle(vehicleid);
			return ResponseEntity.status(HttpStatus.ACCEPTED).body("vehicle with id:" + vehicleid + " is approved");
		} else if (status.equals("reject")) {
			vehicleServiceImpl.rejectVehicle(vehicleid);
			return ResponseEntity.status(HttpStatus.ACCEPTED).body("vehicle with id:" + vehicleid + " is rejected");
		} else {
			return ResponseEntity.status(HttpStatus.ACCEPTED).body("status mismatch");
		}
	}

	private final static String PATH = "/error";

	@RequestMapping(PATH)
	@ResponseBody
	public String getErrorPath() {
		return "No Mapping Found";
	}
}
