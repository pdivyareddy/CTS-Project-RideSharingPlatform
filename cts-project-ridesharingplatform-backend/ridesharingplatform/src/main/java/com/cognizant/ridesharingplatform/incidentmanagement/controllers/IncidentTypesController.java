package com.cognizant.ridesharingplatform.incidentmanagement.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.ridesharingplatform.incidentmanagement.payloads.IncidentTypesDto;
import com.cognizant.ridesharingplatform.incidentmanagement.service.IncidentTypesService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class IncidentTypesController {
	@Autowired
	private IncidentTypesService incidentTypesService;

	@GetMapping("/api/incidents/types")
	public List<IncidentTypesDto> getIncidentTypes() {
		return this.incidentTypesService.getIncidentTypes();
	}
}
