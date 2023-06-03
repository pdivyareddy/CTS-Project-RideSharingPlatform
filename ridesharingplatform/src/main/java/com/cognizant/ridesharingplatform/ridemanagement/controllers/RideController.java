package com.cognizant.ridesharingplatform.ridemanagement.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.ridesharingplatform.ridemanagement.dtos.DistancesDto;
import com.cognizant.ridesharingplatform.ridemanagement.dtos.FareParametersDto;
import com.cognizant.ridesharingplatform.ridemanagement.dtos.RideSchedulesDto;
import com.cognizant.ridesharingplatform.ridemanagement.dtos.SearchCriteriaDto;
import com.cognizant.ridesharingplatform.ridemanagement.entities.Bookings;
import com.cognizant.ridesharingplatform.ridemanagement.exceptions.BadSearchCriteriaException;
import com.cognizant.ridesharingplatform.ridemanagement.exceptions.BookingAlreadyExistException;
import com.cognizant.ridesharingplatform.ridemanagement.exceptions.MaxSeatsPerRideExceededException;
import com.cognizant.ridesharingplatform.ridemanagement.exceptions.MaximumCapacityExceededException;
import com.cognizant.ridesharingplatform.ridemanagement.exceptions.NoRideFoundException;
import com.cognizant.ridesharingplatform.ridemanagement.exceptions.NoVehicleFoundException;
import com.cognizant.ridesharingplatform.ridemanagement.exceptions.VehicleNotApprovedException;
import com.cognizant.ridesharingplatform.ridemanagement.services.RideService;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@RestController
@RequestMapping("/api")
@CrossOrigin(origins="http://localhost:49559")
public class RideController {

	@Autowired
	RideService rideService;

	// EndPoint 1

	@GetMapping("/distances")
	public ResponseEntity<List<DistancesDto>> getAllDistances() {
		log.info("Request for returning distances");
		List<DistancesDto> distances = rideService.getAllDistances();
		log.info("Response generated for returning distances!");
		return new ResponseEntity<>(distances, HttpStatus.OK);
	}

	// ENDPOINT 2

	@GetMapping("/rides/calculatefare")
	public ResponseEntity<Double> calculateFare(@RequestBody FareParametersDto fareParametersDto)
			throws NoRideFoundException {
		log.info("Request for calculating fare");
		double fare = rideService.calculateFare(fareParametersDto);
		return ResponseEntity.ok(fare);
	}
	// ENDPOINT 3

	@PostMapping(path = "rides/schedule", consumes = "application/json")
	public ResponseEntity<Void> insertRide(@Valid @RequestBody RideSchedulesDto rideSchedulesDto)
			throws VehicleNotApprovedException, MaximumCapacityExceededException, NoVehicleFoundException {
		log.info("Request for inserting a new ride");
		//RideSchedulesDto newRide=
		rideService.createRide(rideSchedulesDto);
		log.info("Response Generated for inserting a new ride");
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	// ENDPOINT 4

	@GetMapping(path = "rides/search")
	public List<RideSchedulesDto> searchRideSchedule(@Valid @RequestBody SearchCriteriaDto searchCriteriaDto)
			throws BadSearchCriteriaException, NoRideFoundException {
		log.info("Request for searching ride schedules");
		List<RideSchedulesDto> rides = rideService.searchRideSchedule(searchCriteriaDto);
		if (rides.isEmpty()) {
			throw new NoRideFoundException();
		}
		return rides;

	}
	// ENDPOINT 5
	

	@PostMapping(path = "/rides/book", consumes = "application/json")
	public ResponseEntity<Integer> createBooking(@RequestBody Bookings bookings)
			throws BookingAlreadyExistException, MaxSeatsPerRideExceededException {
		log.info("Request for adding new booking");
		Bookings booking = this.rideService.createBooking(bookings);
		int bookingid = booking.getBookingId();
		log.info("Response generated for adding new booking");
		return new ResponseEntity<Integer>(bookingid, HttpStatus.CREATED);
	}
	
	
	
	
	
	
	
	
	
	
	
	
/*	
	
	// e.Search existing bookings for user   
		@GetMapping("/search/{rideruserid}")
		public ResponseEntity<List<Bookings>> searchBookingByRiderUserId(@PathVariable int rideruserid) throws BookingNotFoundException {
			log.info("Request for searching Booking by user Id");
			List<Bookings> bookings=rideService.searchBookingByRiderUserId(rideruserid);
			log.info("Response generated searching Booking");
			return new ResponseEntity<>(bookings, HttpStatus.OK);
		}
		
*/
/*
	
	@GetMapping("/rideschedules")
	public List<RideSchedules> getAllRideSchedules() {
		log.info("Request for getting all rideschedules");
		return this.rideService.getAllRideSchedules();
	}
	
*/
	
/*
	 @GetMapping("/vehicles")
	public List<Vehicles> getAllVehicles() {
		log.info("Request for getting all vehicles details is sent");
		return this.vehiclesService.getAllVehicles();

	}
*/

}
