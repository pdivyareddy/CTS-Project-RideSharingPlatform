package com.cognizant.ridesharingplatform.vehiclemanagement.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.cognizant.ridesharingplatform.vehiclemanagement.exceptions.CustomException;
import com.cognizant.ridesharingplatform.vehiclemanagement.exceptions.InvalidDocumentException;
import com.cognizant.ridesharingplatform.vehiclemanagement.exceptions.InvalidRegistrationNoException;
import com.cognizant.ridesharingplatform.vehiclemanagement.exceptions.InvalidVehicleAgeException;
import com.cognizant.ridesharingplatform.vehiclemanagement.model.Vehicle;
import com.cognizant.ridesharingplatform.vehiclemanagement.model.VehicleDetails;
import com.cognizant.ridesharingplatform.vehiclemanagement.model.VehicleTypes;
import com.cognizant.ridesharingplatform.vehiclemanagement.repository.VehicleDetailsRepository;
import com.cognizant.ridesharingplatform.vehiclemanagement.repository.VehicleRepository;
import com.cognizant.ridesharingplatform.vehiclemanagement.repository.VehicleTypesRepository;
import com.cognizant.ridesharingplatform.vehiclemanagement.service.VehicleServiceImpl;

@SpringBootTest()
@TestMethodOrder(OrderAnnotation.class)
@RunWith(MockitoJUnitRunner.class)
class VehicleServiceImplTest {

	@Autowired
	VehicleServiceImpl vehicleServiceImpl;

	@Mock
	VehicleRepository vehicleRepository;

	@Mock
	VehicleDetailsRepository vehicleDetailsRepository;

	@Mock
	VehicleTypesRepository vehicleTypesRepository;

	@BeforeClass
	public void init() {
		MockitoAnnotations.openMocks(this);
	}

	@Order(1)
	@Test
	public void testGetAllVehicleTypes() {
		List<String> expectedVehicleTypes = new ArrayList<>();
		expectedVehicleTypes.add("suv");
		expectedVehicleTypes.add("sedan");
		expectedVehicleTypes.add("2 wheeler");
		expectedVehicleTypes.add("jeep");
		expectedVehicleTypes.add("7 wheeler");
		List<String> vehicleTypes = vehicleServiceImpl.getVehicleTypes();
		assertEquals(expectedVehicleTypes, vehicleTypes);
	}

	@Order(2)
	@Test
	public void testGetAllVehicleTypesFail() {
		List<String> expectedVehicleTypes = new ArrayList<>();
		expectedVehicleTypes.add("suv");
		expectedVehicleTypes.add("sedan");
		expectedVehicleTypes.add("2 wheeler");
		expectedVehicleTypes.add("jeep");
		List<String> vehicleTypes = vehicleServiceImpl.getVehicleTypes();
		assertNotEquals(expectedVehicleTypes, vehicleTypes);
	}

	@Order(3)
	@Test
	public void testAddVehicle() throws ParseException {
		VehicleTypes obj = vehicleServiceImpl.getVehicleType("jeep");
		Vehicle vehicle = new Vehicle();
		vehicle.setRegistrationNo("AP29AZ9218");
		vehicle.setBelongsToUserId(159);
		vehicle.setVehicleTypes(obj);
		vehicle.setInspectionStatus("pending");

		String date_string2 = "26-09-2020";
		SimpleDateFormat formatter2 = new SimpleDateFormat("dd-MM-yyyy");
		Date date2 = formatter2.parse(date_string2);

		String date_string3 = "26-09-2026";
		SimpleDateFormat formatter3 = new SimpleDateFormat("dd-MM-yyyy");
		Date date3 = formatter3.parse(date_string3);

		VehicleDetails vehicleDetails = new VehicleDetails();
		vehicleDetails.setRegistrationNo("AP29AZ9218");
		vehicleDetails.setRTOName("AP");
		vehicleDetails.setRegistrationDate(date2);
		vehicleDetails.setRegistrationExpiresOn(date3);
		vehicleDetails.setRCDocURL("D:/Practice Works/sample.html");
		vehicleDetails.setInsuranceCompanyName("delta");
		vehicleDetails.setInsuranceNo(35464);
		vehicleDetails.setInsurancedOn(date2);
		vehicleDetails.setInsuranceExpiresOn(date3);
		vehicleDetails.setInsuranceCertificateDOCURL("D:/Practice Works/sample.html");
		vehicleDetails.setPUCCertificateNo(37458);
		vehicleDetails.setPUCIssuedOn(date2);
		vehicleDetails.setPUCValidUntil(date3);
		vehicleDetails.setPUCDOCURL("D:/Practice Works/sample.html");

		vehicle.setVehicleDetails(vehicleDetails);

		ResponseEntity<String> message = vehicleServiceImpl.addVehicle(vehicle);
		assertTrue(message.equals(ResponseEntity.status(HttpStatus.OK).body("vehicle added")));
	}

	@Order(4)
	@Test
	public void testAddVehicleInvalidRegistrationNo() throws ParseException {
		VehicleTypes obj = vehicleServiceImpl.getVehicleType("jeep");
		Vehicle vehicle = new Vehicle();
		vehicle.setRegistrationNo("AP27AZ114534");
		vehicle.setBelongsToUserId(754);
		vehicle.setVehicleTypes(obj);
		vehicle.setInspectionStatus("pending");

		String date_string2 = "26-09-2020";
		SimpleDateFormat formatter2 = new SimpleDateFormat("dd-MM-yyyy");
		Date date2 = formatter2.parse(date_string2);

		String date_string3 = "26-09-2026";
		SimpleDateFormat formatter3 = new SimpleDateFormat("dd-MM-yyyy");
		Date date3 = formatter3.parse(date_string3);

		VehicleDetails vehicleDetails = new VehicleDetails();
		vehicleDetails.setRegistrationNo("AP27AZ114534");
		vehicleDetails.setRTOName("AP");
		vehicleDetails.setRegistrationDate(date2);
		vehicleDetails.setRegistrationExpiresOn(date3);
		vehicleDetails.setRCDocURL("D:/Practice Works/sample.html");
		vehicleDetails.setInsuranceCompanyName("delta");
		vehicleDetails.setInsuranceNo(35464);
		vehicleDetails.setInsurancedOn(date2);
		vehicleDetails.setInsuranceExpiresOn(date3);
		vehicleDetails.setInsuranceCertificateDOCURL("D:/Practice Works/sample.html");
		vehicleDetails.setPUCCertificateNo(37458);
		vehicleDetails.setPUCIssuedOn(date2);
		vehicleDetails.setPUCValidUntil(date3);
		vehicleDetails.setPUCDOCURL("D:/Practice Works/sample.html");

		vehicle.setVehicleDetails(vehicleDetails);

		vehicleServiceImpl.addVehicle(vehicle);

		InvalidRegistrationNoException invalidRegNo = new InvalidRegistrationNoException(
				"Invalid registration number format");

		ResponseEntity<String> message = vehicleServiceImpl.addVehicle(vehicle);
		assertTrue(message.equals(ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(invalidRegNo.getMessage())));
	}

	@Order(5)
	@Test
	public void testAddVehicleInvalidVehicleAge() throws ParseException {
		VehicleTypes obj = vehicleServiceImpl.getVehicleType("jeep");
		Vehicle vehicle = new Vehicle();
		vehicle.setRegistrationNo("AP27AZ1534");
		vehicle.setBelongsToUserId(754);
		vehicle.setVehicleTypes(obj);
		vehicle.setInspectionStatus("pending");

		String date_string2 = "26-09-2000";
		SimpleDateFormat formatter2 = new SimpleDateFormat("dd-MM-yyyy");
		Date date2 = formatter2.parse(date_string2);

		String date_string3 = "26-09-2026";
		SimpleDateFormat formatter3 = new SimpleDateFormat("dd-MM-yyyy");
		Date date3 = formatter3.parse(date_string3);

		VehicleDetails vehicleDetails = new VehicleDetails();
		vehicleDetails.setRegistrationNo("AP27AZ1534");
		vehicleDetails.setRTOName("AP");
		vehicleDetails.setRegistrationDate(date2);
		vehicleDetails.setRegistrationExpiresOn(date3);
		vehicleDetails.setRCDocURL("D:/Practice Works/sample.html");
		vehicleDetails.setInsuranceCompanyName("delta");
		vehicleDetails.setInsuranceNo(35464);
		vehicleDetails.setInsurancedOn(date2);
		vehicleDetails.setInsuranceExpiresOn(date3);
		vehicleDetails.setInsuranceCertificateDOCURL("D:/Practice Works/sample.html");
		vehicleDetails.setPUCCertificateNo(37458);
		vehicleDetails.setPUCIssuedOn(date2);
		vehicleDetails.setPUCValidUntil(date3);
		vehicleDetails.setPUCDOCURL("D:/Practice Works/sample.html");

		vehicle.setVehicleDetails(vehicleDetails);

		vehicleServiceImpl.addVehicle(vehicle);

		InvalidVehicleAgeException invalidVehicleAge = new InvalidVehicleAgeException(
				"Vehicle must not be more than 15 years old");

		ResponseEntity<String> message = vehicleServiceImpl.addVehicle(vehicle);
		assertTrue(
				message.equals(ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(invalidVehicleAge.getMessage())));
	}

	@Order(6)
	@Test
	public void testAddVehicleInvalidRCDates() throws ParseException {
		VehicleTypes obj = vehicleServiceImpl.getVehicleType("jeep");
		Vehicle vehicle = new Vehicle();
		vehicle.setRegistrationNo("AP27AZ1534");
		vehicle.setBelongsToUserId(754);
		vehicle.setVehicleTypes(obj);
		vehicle.setInspectionStatus("pending");

		String date_string2 = "26-09-2020";
		SimpleDateFormat formatter2 = new SimpleDateFormat("dd-MM-yyyy");
		Date date2 = formatter2.parse(date_string2);

		String date_string3 = "26-09-2022";
		SimpleDateFormat formatter3 = new SimpleDateFormat("dd-MM-yyyy");
		Date date3 = formatter3.parse(date_string3);

		VehicleDetails vehicleDetails = new VehicleDetails();
		vehicleDetails.setRegistrationNo("AP27AZ1534");
		vehicleDetails.setRTOName("AP");
		vehicleDetails.setRegistrationDate(date2);
		vehicleDetails.setRegistrationExpiresOn(date3);
		vehicleDetails.setRCDocURL("D:/Practice Works/sample.html");
		vehicleDetails.setInsuranceCompanyName("delta");
		vehicleDetails.setInsuranceNo(35464);
		vehicleDetails.setInsurancedOn(date2);
		vehicleDetails.setInsuranceExpiresOn(date3);
		vehicleDetails.setInsuranceCertificateDOCURL("D:/Practice Works/sample.html");
		vehicleDetails.setPUCCertificateNo(37458);
		vehicleDetails.setPUCIssuedOn(date2);
		vehicleDetails.setPUCValidUntil(date3);
		vehicleDetails.setPUCDOCURL("D:/Practice Works/sample.html");

		vehicle.setVehicleDetails(vehicleDetails);

		vehicleServiceImpl.addVehicle(vehicle);

		InvalidDocumentException invalidDocRCDates = new InvalidDocumentException(
				"RC validity should be for atleast 2 years");

		ResponseEntity<String> message = vehicleServiceImpl.addVehicle(vehicle);
		assertTrue(
				message.equals(ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(invalidDocRCDates.getMessage())));

	}

	@Order(7)
	@Test
	public void testAddVehicleInvalidRCFileSize() throws ParseException {
		VehicleTypes obj = vehicleServiceImpl.getVehicleType("jeep");
		Vehicle vehicle = new Vehicle();
		vehicle.setRegistrationNo("AP29AZ9218");
		vehicle.setBelongsToUserId(159);
		vehicle.setVehicleTypes(obj);
		vehicle.setInspectionStatus("pending");

		String date_string2 = "26-09-2020";
		SimpleDateFormat formatter2 = new SimpleDateFormat("dd-MM-yyyy");
		Date date2 = formatter2.parse(date_string2);

		String date_string3 = "26-09-2026";
		SimpleDateFormat formatter3 = new SimpleDateFormat("dd-MM-yyyy");
		Date date3 = formatter3.parse(date_string3);

		VehicleDetails vehicleDetails = new VehicleDetails();
		vehicleDetails.setRegistrationNo("AP29AZ9218");
		vehicleDetails.setRTOName("AP");
		vehicleDetails.setRegistrationDate(date2);
		vehicleDetails.setRegistrationExpiresOn(date3);
		vehicleDetails.setRCDocURL("D:/IndianServers-Internship/True.csv");
		vehicleDetails.setInsuranceCompanyName("delta");
		vehicleDetails.setInsuranceNo(35464);
		vehicleDetails.setInsurancedOn(date2);
		vehicleDetails.setInsuranceExpiresOn(date3);
		vehicleDetails.setInsuranceCertificateDOCURL("D:/Practice Works/sample.html");
		vehicleDetails.setPUCCertificateNo(37458);
		vehicleDetails.setPUCIssuedOn(date2);
		vehicleDetails.setPUCValidUntil(date3);
		vehicleDetails.setPUCDOCURL("D:/Practice Works/sample.html");

		vehicle.setVehicleDetails(vehicleDetails);

		InvalidDocumentException invalidDocRCFileSize = new InvalidDocumentException(
				"RC document size exceeded 1024KB limit");

		ResponseEntity<String> message = vehicleServiceImpl.addVehicle(vehicle);
		assertTrue(message
				.equals(ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(invalidDocRCFileSize.getMessage())));
	}

	@Order(8)
	@Test
	public void testAddVehicleInvalidInsuranceDates() throws ParseException {
		VehicleTypes obj = vehicleServiceImpl.getVehicleType("jeep");
		Vehicle vehicle = new Vehicle();
		vehicle.setRegistrationNo("AP27AZ1534");
		vehicle.setBelongsToUserId(754);
		vehicle.setVehicleTypes(obj);
		vehicle.setInspectionStatus("pending");

		String date_string2 = "26-09-2015";
		SimpleDateFormat formatter2 = new SimpleDateFormat("dd-MM-yyyy");
		Date date2 = formatter2.parse(date_string2);

		String date_string3 = "26-09-2026";
		SimpleDateFormat formatter3 = new SimpleDateFormat("dd-MM-yyyy");
		Date date3 = formatter3.parse(date_string3);

		String date_string4 = "26-09-2023";
		SimpleDateFormat formatter4 = new SimpleDateFormat("dd-MM-yyyy");
		Date date4 = formatter4.parse(date_string4);

		VehicleDetails vehicleDetails = new VehicleDetails();
		vehicleDetails.setRegistrationNo("AP27AZ1534");
		vehicleDetails.setRTOName("AP");
		vehicleDetails.setRegistrationDate(date2);
		vehicleDetails.setRegistrationExpiresOn(date3);
		vehicleDetails.setRCDocURL("D:/Practice Works/sample.html");
		vehicleDetails.setInsuranceCompanyName("delta");
		vehicleDetails.setInsuranceNo(35464);
		vehicleDetails.setInsurancedOn(date2);
		vehicleDetails.setInsuranceExpiresOn(date4);
		vehicleDetails.setInsuranceCertificateDOCURL("D:/Practice Works/sample.html");
		vehicleDetails.setPUCCertificateNo(37458);
		vehicleDetails.setPUCIssuedOn(date2);
		vehicleDetails.setPUCValidUntil(date4);
		vehicleDetails.setPUCDOCURL("D:/Practice Works/sample.html");

		vehicle.setVehicleDetails(vehicleDetails);

		vehicleServiceImpl.addVehicle(vehicle);

		InvalidDocumentException invalidDocInsuranceDates = new InvalidDocumentException(
				"Insurance validity should be for atleast 1 year");

		ResponseEntity<String> message = vehicleServiceImpl.addVehicle(vehicle);
		assertTrue(message
				.equals(ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(invalidDocInsuranceDates.getMessage())));
	}

	@Order(9)
	@Test
	public void testAddVehicleInvalidInsuranceFileSize() throws ParseException {
		VehicleTypes obj = vehicleServiceImpl.getVehicleType("jeep");
		Vehicle vehicle = new Vehicle();
		vehicle.setRegistrationNo("AP29AZ9218");
		vehicle.setBelongsToUserId(159);
		vehicle.setVehicleTypes(obj);
		vehicle.setInspectionStatus("pending");

		String date_string2 = "26-09-2020";
		SimpleDateFormat formatter2 = new SimpleDateFormat("dd-MM-yyyy");
		Date date2 = formatter2.parse(date_string2);

		String date_string3 = "26-09-2026";
		SimpleDateFormat formatter3 = new SimpleDateFormat("dd-MM-yyyy");
		Date date3 = formatter3.parse(date_string3);

		VehicleDetails vehicleDetails = new VehicleDetails();
		vehicleDetails.setRegistrationNo("AP29AZ9218");
		vehicleDetails.setRTOName("AP");
		vehicleDetails.setRegistrationDate(date2);
		vehicleDetails.setRegistrationExpiresOn(date3);
		vehicleDetails.setRCDocURL("D:/Practice Works/sample.html");
		vehicleDetails.setInsuranceCompanyName("delta");
		vehicleDetails.setInsuranceNo(35464);
		vehicleDetails.setInsurancedOn(date2);
		vehicleDetails.setInsuranceExpiresOn(date3);
		vehicleDetails.setInsuranceCertificateDOCURL("D:/IndianServers-Internship/True.csv");
		vehicleDetails.setPUCCertificateNo(37458);
		vehicleDetails.setPUCIssuedOn(date2);
		vehicleDetails.setPUCValidUntil(date3);
		vehicleDetails.setPUCDOCURL("D:/Practice Works/sample.html");

		vehicle.setVehicleDetails(vehicleDetails);

		InvalidDocumentException invalidDocInsuranceFileSize = new InvalidDocumentException(
				"Insurance document size exceeded 1024KB limit");

		ResponseEntity<String> message = vehicleServiceImpl.addVehicle(vehicle);
		assertTrue(message.equals(
				ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(invalidDocInsuranceFileSize.getMessage())));
	}

	@Order(10)
	@Test
	public void testAddVehicleInvalidPUCDates() throws ParseException {
		VehicleTypes obj = vehicleServiceImpl.getVehicleType("jeep");
		Vehicle vehicle = new Vehicle();
		vehicle.setRegistrationNo("AP27AZ1534");
		vehicle.setBelongsToUserId(754);
		vehicle.setVehicleTypes(obj);
		vehicle.setInspectionStatus("pending");

		String date_string2 = "26-09-2015";
		SimpleDateFormat formatter2 = new SimpleDateFormat("dd-MM-yyyy");
		Date date2 = formatter2.parse(date_string2);

		String date_string3 = "26-09-2026";
		SimpleDateFormat formatter3 = new SimpleDateFormat("dd-MM-yyyy");
		Date date3 = formatter3.parse(date_string3);

		String date_string4 = "26-09-2023";
		SimpleDateFormat formatter4 = new SimpleDateFormat("dd-MM-yyyy");
		Date date4 = formatter4.parse(date_string4);

		VehicleDetails vehicleDetails = new VehicleDetails();
		vehicleDetails.setRegistrationNo("AP27AZ1534");
		vehicleDetails.setRTOName("AP");
		vehicleDetails.setRegistrationDate(date2);
		vehicleDetails.setRegistrationExpiresOn(date3);
		vehicleDetails.setRCDocURL("D:/Practice Works/sample.html");
		vehicleDetails.setInsuranceCompanyName("delta");
		vehicleDetails.setInsuranceNo(35464);
		vehicleDetails.setInsurancedOn(date2);
		vehicleDetails.setInsuranceExpiresOn(date3);
		vehicleDetails.setInsuranceCertificateDOCURL("D:/Practice Works/sample.html");
		vehicleDetails.setPUCCertificateNo(37458);
		vehicleDetails.setPUCIssuedOn(date2);
		vehicleDetails.setPUCValidUntil(date4);
		vehicleDetails.setPUCDOCURL("D:/Practice Works/sample.html");

		vehicle.setVehicleDetails(vehicleDetails);

		vehicleServiceImpl.addVehicle(vehicle);

		InvalidDocumentException invalidDocPUCDates = new InvalidDocumentException(
				"PUC validity should be for atleast 6 months");

		ResponseEntity<String> message = vehicleServiceImpl.addVehicle(vehicle);
		assertTrue(
				message.equals(ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(invalidDocPUCDates.getMessage())));
	}

	@Order(11)
	@Test
	public void testAddVehicleInvalidPUCFileSize() throws ParseException {
		VehicleTypes obj = vehicleServiceImpl.getVehicleType("jeep");
		Vehicle vehicle = new Vehicle();
		vehicle.setRegistrationNo("AP29AZ9218");
		vehicle.setBelongsToUserId(159);
		vehicle.setVehicleTypes(obj);
		vehicle.setInspectionStatus("pending");

		String date_string2 = "26-09-2020";
		SimpleDateFormat formatter2 = new SimpleDateFormat("dd-MM-yyyy");
		Date date2 = formatter2.parse(date_string2);

		String date_string3 = "26-09-2026";
		SimpleDateFormat formatter3 = new SimpleDateFormat("dd-MM-yyyy");
		Date date3 = formatter3.parse(date_string3);

		VehicleDetails vehicleDetails = new VehicleDetails();
		vehicleDetails.setRegistrationNo("AP29AZ9218");
		vehicleDetails.setRTOName("AP");
		vehicleDetails.setRegistrationDate(date2);
		vehicleDetails.setRegistrationExpiresOn(date3);
		vehicleDetails.setRCDocURL("D:/Practice Works/sample.html");
		vehicleDetails.setInsuranceCompanyName("delta");
		vehicleDetails.setInsuranceNo(35464);
		vehicleDetails.setInsurancedOn(date2);
		vehicleDetails.setInsuranceExpiresOn(date3);
		vehicleDetails.setInsuranceCertificateDOCURL("D:/Practice Works/sample.html");
		vehicleDetails.setPUCCertificateNo(37458);
		vehicleDetails.setPUCIssuedOn(date2);
		vehicleDetails.setPUCValidUntil(date3);
		vehicleDetails.setPUCDOCURL("D:/IndianServers-Internship/True.csv");

		vehicle.setVehicleDetails(vehicleDetails);

		InvalidDocumentException invalidDocPUCFileSize = new InvalidDocumentException(
				"PUC document size exceeded 1024KB limit");

		ResponseEntity<String> message = vehicleServiceImpl.addVehicle(vehicle);
		assertTrue(message
				.equals(ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(invalidDocPUCFileSize.getMessage())));
	}

	@Order(12)
	@Test
	public void testApproveVehicle() {
		boolean message = vehicleServiceImpl.approveVehicle("AP29AZ9198");
		assertTrue(message);
	}

	@Order(13)
	@Test
	public void testApproveVehicleFail() {
		boolean message = vehicleServiceImpl.approveVehicle("AP29AZ9008");
		assertFalse(message);
	}

	@Order(14)
	@Test
	public void testRejectVehicle() {
		boolean message = vehicleServiceImpl.rejectVehicle("AP29AZ9198");
		assertTrue(message);
	}

	@Order(15)
	@Test
	public void testRejectVehicleFail() {
		boolean message = vehicleServiceImpl.rejectVehicle("AP29AZ9008");
		assertFalse(message);
	}

	@Order(16)
	@Test
	public void testDeleteVehicle() throws CustomException {
		boolean message = vehicleServiceImpl.deleteVehicle("AP29AZ9218");
		assertTrue(message);
	}

	@Order(17)
	@Test
	public void testDeleteVehicleFail() throws CustomException {
		boolean message = vehicleServiceImpl.deleteVehicle("AP27CY6487");
		assertFalse(message);
	}

	@Order(18)
	@Test
	public void testGetVehicleByUserId() throws ParseException, CustomException {
		VehicleTypes obj = vehicleServiceImpl.getVehicleType("jeep");
		Vehicle vehicle = new Vehicle();
		vehicle.setRegistrationNo("AP29AZ1118");
		vehicle.setBelongsToUserId(347);
		vehicle.setVehicleTypes(obj);
		vehicle.setInspectionStatus("pending");

		String date_string2 = "26-09-2020";
		SimpleDateFormat formatter2 = new SimpleDateFormat("dd-MM-yyyy");
		Date date2 = formatter2.parse(date_string2);

		String date_string3 = "26-09-2026";
		SimpleDateFormat formatter3 = new SimpleDateFormat("dd-MM-yyyy");
		Date date3 = formatter3.parse(date_string3);

		VehicleDetails vehicleDetails = new VehicleDetails();
		vehicleDetails.setRegistrationNo("AP29AZ1118");
		vehicleDetails.setRTOName("AP");
		vehicleDetails.setRegistrationDate(date2);
		vehicleDetails.setRegistrationExpiresOn(date3);
		vehicleDetails.setRCDocURL("D:/Practice Works/sample.html");
		vehicleDetails.setInsuranceCompanyName("delta");
		vehicleDetails.setInsuranceNo(35464);
		vehicleDetails.setInsurancedOn(date2);
		vehicleDetails.setInsuranceExpiresOn(date3);
		vehicleDetails.setInsuranceCertificateDOCURL("D:/Practice Works/sample.html");
		vehicleDetails.setPUCCertificateNo(37458);
		vehicleDetails.setPUCIssuedOn(date2);
		vehicleDetails.setPUCValidUntil(date3);
		vehicleDetails.setPUCDOCURL("D:/Practice Works/sample.html");

		vehicle.setVehicleDetails(vehicleDetails);

		vehicleServiceImpl.addVehicle(vehicle);

		Vehicle vehicle2 = vehicleServiceImpl.getVehicleByUserId(347);
		assertTrue(vehicle.getRegistrationNo().equals(vehicle2.getRegistrationNo()));

		boolean message = vehicleServiceImpl.deleteVehicle("AP29AZ1118");
		assertTrue(message);
	}

	@Order(19)
	@Test
	public void testGetVehicleByUserIdFail() throws ParseException, CustomException {
		Vehicle vehicle = vehicleServiceImpl.getVehicleByUserId(000);
		assertEquals(null, vehicle);
	}

}
