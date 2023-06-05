package com.cognizant.ridesharingplatform.vehiclemanagement.service;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cognizant.ridesharingplatform.vehiclemanagement.dto.VehicleDTO;
import com.cognizant.ridesharingplatform.vehiclemanagement.dto.VehicleTypesDTO;
import com.cognizant.ridesharingplatform.vehiclemanagement.exceptions.CustomException;
import com.cognizant.ridesharingplatform.vehiclemanagement.exceptions.InvalidDocumentException;
import com.cognizant.ridesharingplatform.vehiclemanagement.exceptions.InvalidRegistrationNoException;
import com.cognizant.ridesharingplatform.vehiclemanagement.exceptions.InvalidVehicleAgeException;
import com.cognizant.ridesharingplatform.vehiclemanagement.model.Vehicle;
import com.cognizant.ridesharingplatform.vehiclemanagement.model.VehicleTypes;
import com.cognizant.ridesharingplatform.vehiclemanagement.repository.VehicleDetailsRepository;
import com.cognizant.ridesharingplatform.vehiclemanagement.repository.VehicleRepository;
import com.cognizant.ridesharingplatform.vehiclemanagement.repository.VehicleTypesRepository;

@Service
public class VehicleServiceImpl implements VehicleService {

	@Autowired
	VehicleRepository vehicleRepository;

	@Autowired
	VehicleTypesRepository vehicleTypesRepository;

	@Autowired
	VehicleDetailsRepository vehicleDetailsRepository;

	private ModelMapper modelMapper = new ModelMapper();
	
    private static String pattern = "^[A-Z]{2}\\d{2}[A-Z]{2}\\d{4}$";

	public List<String> getVehicleTypes() {
		List<String> vehicleTypes = vehicleTypesRepository.getVehicleTypes();
		return vehicleTypes;
	}

	public List<VehicleTypesDTO> getAllVehicleTypesDetails() {
		List<VehicleTypes> vt = vehicleTypesRepository.findAll();
		List<VehicleTypesDTO> vehicleTypeDTOs = vt.stream().map(x -> modelMapper.map(x, VehicleTypesDTO.class))
				.collect(Collectors.toList());
		return vehicleTypeDTOs;
	}

	public ResponseEntity<String> addVehicle(Vehicle vehicle) {
		try {
			if(!vehicle.getRegistrationNo().matches(pattern)) {
				throw new InvalidRegistrationNoException("Invalid registration number format");
			}
		} catch (InvalidRegistrationNoException ex) {
			System.out.println(ex.getMessage());
			return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(ex.getMessage());

		}

		// Validate vehicle age
		int ageInYears = Math
				.abs(Period
						.between(LocalDate.parse(new SimpleDateFormat("yyyy-MM-dd")
								.format(vehicle.getVehicleDetails().getRegistrationDate())), LocalDate.now())
						.getYears());

		try {
			if (ageInYears > 15) {
				throw new InvalidVehicleAgeException("Vehicle must not be more than 15 years old");
			}
		} catch (InvalidVehicleAgeException ex) {
			System.out.println(ex.getMessage());
			return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(ex.getMessage());
		}

		// Validate RC
		File RCfile = new File(vehicle.getVehicleDetails().getRCDocURL());
		long RCfilesize = RCfile.length();

		try {
			if (RCfilesize > 1024 * 1024) {
				throw new InvalidDocumentException("RC document size exceeded 1024KB limit");
			}
		} catch (InvalidDocumentException ex) {
			System.out.println(ex.getMessage());
			return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(ex.getMessage());
		}

		LocalDate rcExpiryDate = LocalDate.parse(
				new SimpleDateFormat("yyyy-MM-dd").format(vehicle.getVehicleDetails().getRegistrationExpiresOn()));
		try {
			if (Math.abs(Period.between(LocalDate.now(), rcExpiryDate).getYears()) < 2) {
				throw new InvalidDocumentException("RC validity should be for atleast 2 years");
			}
		} catch (InvalidDocumentException ex) {
			System.out.println(ex.getMessage());
			return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(ex.getMessage());
		}

		// Validate insurance
		File Insurancefile = new File(vehicle.getVehicleDetails().getInsuranceCertificateDOCURL());
		long Insurancefilesize = Insurancefile.length();

		try {
			if (Insurancefilesize > 1024 * 1024) {
				throw new InvalidDocumentException("Insurance document size exceeded 1024KB limit");
			}
		} catch (InvalidDocumentException ex) {
			System.out.println(ex.getMessage());
			return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(ex.getMessage());
		}

		LocalDate insuranceExpiryDate = LocalDate
				.parse(new SimpleDateFormat("yyyy-MM-dd").format(vehicle.getVehicleDetails().getInsuranceExpiresOn()));
		try {
			if (Math.abs(Period.between(LocalDate.now(), insuranceExpiryDate).getYears()) < 1) {
				throw new InvalidDocumentException("Insurance validity should be for atleast 1 year");
			}
		} catch (InvalidDocumentException ex) {
			System.out.println(ex.getMessage());
			return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(ex.getMessage());
		}

		// Validate PUC
		File PUCfile = new File(vehicle.getVehicleDetails().getPUCDOCURL());
		long PUCfilesize = PUCfile.length();

		try {
			if (PUCfilesize > 1024 * 1024) {
				throw new InvalidDocumentException("PUC document size exceeded 1024KB limit");
			}
		} catch (InvalidDocumentException ex) {
			System.out.println(ex.getMessage());
			return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(ex.getMessage());
		}

		LocalDate pucExpiryDate = LocalDate
				.parse(new SimpleDateFormat("yyyy-MM-dd").format(vehicle.getVehicleDetails().getPUCValidUntil()));
		try {
			if (Math.abs(Period.between(LocalDate.now(), pucExpiryDate).getYears()) < 1
					&& Math.abs(Period.between(LocalDate.now(), pucExpiryDate).getMonths()) < 6) {
				throw new InvalidDocumentException("PUC validity should be for atleast 6 months");
			}
		} catch (InvalidDocumentException ex) {
			System.out.println(ex.getMessage());
			return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(ex.getMessage());
		}

		vehicleRepository.save(vehicle);
		return ResponseEntity.status(HttpStatus.OK).body("vehicle added");
	}

	public boolean checkIfVehicleExistsByRegistrationNo(String registrationNo) {
		try {
			Vehicle vehicle = vehicleRepository.findByRegistrationNo(registrationNo);
			if (vehicle == null)
				throw new CustomException("no vehicle found with registrationNo:" + registrationNo);
		} catch (CustomException ex) {
			System.out.println(ex);
			return false;
		}
		return true;
	}

	public boolean deleteVehicle(String registrationNo) throws CustomException {
		if (!checkIfVehicleExistsByRegistrationNo(registrationNo))
			return false;
		vehicleRepository.deleteByRegistrationNo(registrationNo);
		return true;
	}

	public boolean approveVehicle(String registrationNo) {
		if (!checkIfVehicleExistsByRegistrationNo(registrationNo))
			return false;
		vehicleRepository.approveVehicle(registrationNo);
		return true;
	}

	public boolean rejectVehicle(String registrationNo) {
		if (!checkIfVehicleExistsByRegistrationNo(registrationNo))
			return false;
		vehicleRepository.rejectVehicle(registrationNo);
		return true;
	}

	public Vehicle getVehicleByUserId(int userId) throws CustomException {
		Vehicle vehicle = null;
		try {
			vehicle = vehicleRepository.findByBelongsToUserId(userId);
			if (vehicle == null)
				throw new CustomException("no vehicle found with userid:" + userId);
		} catch (CustomException ex) {
			System.out.println(ex);
		}
		return vehicle;
	}

	public List<VehicleDTO> getVehicleDTOByUserId(int userId) throws CustomException {
		List<VehicleDTO> vehicleDTOs = null;
		try {
			List<Vehicle> v = vehicleRepository.findAllByBelongsToUserId(userId);
			vehicleDTOs = v.stream().map(x -> modelMapper.map(x, VehicleDTO.class)).collect(Collectors.toList());
			if (v == null)
				throw new CustomException("no vehicle found with userid:" + userId);
		} catch (CustomException ex) {
			System.out.println(ex);
		}
		return vehicleDTOs;
	}

	public ArrayList<VehicleDTO> getApprovalPendingVehicles() {
		List<Object[]> approvalPendingVehicles = vehicleRepository.getApprovalPendingVehicles();
		ArrayList<VehicleDTO> al = new ArrayList<VehicleDTO>();
		for (Object[] obj : approvalPendingVehicles) {
			VehicleDTO vehicleDTO = this.modelMapper.map((Vehicle) obj[0], VehicleDTO.class);
			al.add(vehicleDTO);
		}
		return al;
	}

	public Vehicle getSingleVehiclePageWise(int pageno) throws CustomException {
		List<Vehicle> allVehicles = vehicleRepository.findAll();
		if (allVehicles.size() == 0)
			throw new CustomException("No vehicles exist");
		Vehicle vehicle = null;
		try {
			vehicle = allVehicles.get(pageno - 1);
		} catch (IndexOutOfBoundsException ex) {
			throw new CustomException("IndexOutOfBoundsException -> no vehicle at page:" + pageno);
		}
		return vehicle;
	}

	public Vehicle getVehicleByRegistrationNo(String registrationNo) throws CustomException {
		Vehicle vehicle = vehicleRepository.findByRegistrationNo(registrationNo);
//		if (vehicle == null)
//			throw new CustomException("no vehicle found with registrationNo:" + registrationNo);
		return vehicle;
	}

	public VehicleTypes getVehicleType(String type) {
		return vehicleTypesRepository.findByType(type);
	}

}
