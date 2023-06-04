package com.cognizant.ridesharingplatform.ridemanagement;


import java.time.LocalDate;
import java.time.LocalTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import com.cognizant.ridesharingplatform.ridemanagement.entities.Bookings;
import com.cognizant.ridesharingplatform.ridemanagement.entities.Distances;
import com.cognizant.ridesharingplatform.ridemanagement.entities.RideSchedules;
import com.cognizant.ridesharingplatform.vehiclemanagement.model.Vehicle;
import com.cognizant.ridesharingplatform.ridemanagement.repos.BookingsRepository;
import com.cognizant.ridesharingplatform.ridemanagement.repos.DistancesRepository;
import com.cognizant.ridesharingplatform.ridemanagement.repos.RideSchedulesRepository;
import com.cognizant.ridesharingplatform.vehiclemanagement.repository.VehicleRepository;

@SpringBootTest(classes = {com.cognizant.ridesharingplatform.RidesharingplatformApplication.class})
class RidemanagementApplicationTests {

	@Autowired
	ApplicationContext context;

	@Test
	public void createRide() {
		
		VehicleRepository vehiclesRepository=context.getBean(VehicleRepository.class);
		Vehicle vehicles=new Vehicle();
		vehicles.setRegistrationNo("AP04123456");
		vehicles.setInspectionStatus("approved");
		vehicles.setBelongsToUserId(0);
		vehiclesRepository.save(vehicles);
		

		RideSchedulesRepository rideschedulesRepository=context.getBean(RideSchedulesRepository.class);
		RideSchedules rideschedules=new RideSchedules();
		rideschedules.setId(7001);
		rideschedules.setRideFrom("Point E");
		rideschedules.setNoOfSeatsAvailable(3);
		rideschedules.setMotoristUserId(9001);
		rideschedules.setRideFare(33);
		rideschedules.setRideTo("Point F");
		rideschedules.setVehicleRegistrationNo("AP04123456");
		rideschedules.setRideStartsOn(LocalDate.of(2023,12,28));
		rideschedules.setRideTime(LocalTime.of(23, 50));
		rideschedulesRepository.save(rideschedules);
		
		DistancesRepository distancesRepository=context.getBean(DistancesRepository.class);
		Distances distances=new Distances();
		distances.setDistancefrom("Point E");
		distances.setDistanceTo("Point D");
		distances.setDistanceInKms(500);
		distancesRepository.save(distances);
		
		
		BookingsRepository bookingsRepository=context.getBean(BookingsRepository.class);
		Bookings bookings=new Bookings();
		bookings.setBookingId(1);
		bookings.setBookedOn(6);
		bookings.setRideschedeules(rideschedules);
		bookings.setNoOfSeats(1);
		bookings.setRiderUserId(8001);
		bookings.setPaymentMode("cash");
		bookings.setTotalAmount(444);
		bookingsRepository.save(bookings);
		
}
}
