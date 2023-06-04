package com.cognizant.ridesharingplatform.incidentmanagement.service.impl;
import java.util.concurrent.atomic.AtomicInteger;
import java.time.LocalDate;
import java.time.Year;
import java.time.temporal.ChronoUnit;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.ridesharingplatform.incidentmanagement.entities.Incidents;
import com.cognizant.ridesharingplatform.incidentmanagement.repo.IncidentsRepo;
import com.cognizant.ridesharingplatform.incidentmanagement.service.IncidentsService;


@Service
public class IncidentsServiceImp implements IncidentsService{
	@Autowired
	IncidentsRepo incRepo;
	 private AtomicInteger incidentCounter = new AtomicInteger(0);
	@Override
	public String generateIncidentId() {
		 int uniqueNumber = incidentCounter.incrementAndGet();
	        int currentYear = Year.now().getValue();
	        return String.format("%04d-%04d", currentYear, uniqueNumber);
	}
	
	 @Override
	    public void insertIncident(Incidents incidents) throws CannotReportIncidentException {
		 int bookingId = incidents.getBookingId();
	        // Check if an incident already exists for the given booking ID
	        boolean incidentExists = incRepo.existsByBookingId(bookingId);
	        if (incidentExists) {
	            throw new CannotReportIncidentException("An incident already exists for the given booking ID");
	        }
	        LocalDate currentDate = LocalDate.now();
	        LocalDate incidentDate = incidents.getIncidentDate();
	        long daysBetween = ChronoUnit.DAYS.between(incidentDate, currentDate);
	        
	        if (daysBetween > 2) {
	            throw new CannotReportIncidentException("Cannot report incident after 2 days");
	            
	        }
	        incRepo.save(incidents);
	 }

	@Override
	public List<Incidents> getIncidents() {
		
		return incRepo.findAll();
	}
	public Incidents getIncidentsById(String id) {
		
		return incRepo.findById(id).get();
	}
	@Override
	public Incidents updateIncidentById( Incidents incidents) {
		
		return incRepo.save(incidents);
	}
	@Override
	public void calculateETA(Incidents incidents) {
		// TODO Auto-generated method stub
		
	}
	
}
