package com.cognizant.ridesharingplatform.incidentmanagement.service;

import java.util.List;

import com.cognizant.ridesharingplatform.incidentmanagement.entities.Incidents;
import com.cognizant.ridesharingplatform.incidentmanagement.service.impl.CannotReportIncidentException;


public interface IncidentsService {
	
	void insertIncident(Incidents incidents) throws CannotReportIncidentException ;
	List<Incidents> getIncidents();
	Incidents getIncidentsById(String id);
	Incidents updateIncidentById(Incidents incidents);
	
	String generateIncidentId();
	void calculateETA(Incidents incidents);
}
