package com.cognizant.ridesharingplatform.incidentmanagement.service;

import java.util.List;

import com.cognizant.ridesharingplatform.incidentmanagement.payloads.IncidentTypesDto;

public interface IncidentTypesService {
	
	public List<IncidentTypesDto> getIncidentTypes();

}
