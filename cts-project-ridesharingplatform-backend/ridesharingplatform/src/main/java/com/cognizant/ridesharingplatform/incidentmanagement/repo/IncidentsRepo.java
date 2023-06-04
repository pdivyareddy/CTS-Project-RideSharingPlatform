package com.cognizant.ridesharingplatform.incidentmanagement.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.ridesharingplatform.incidentmanagement.entities.Incidents;

public interface IncidentsRepo extends JpaRepository<Incidents,String> {

	boolean existsByBookingId(int bookingId);

}
