package com.cognizant.ridesharingplatform.ridemanagement.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.ridesharingplatform.ridemanagement.entities.Bookings;

public interface BookingsRepository extends JpaRepository<Bookings,Integer>{

	//e.Search existing bookings for user
	List<Bookings> findByRiderUserId(int riderUserId);

}
