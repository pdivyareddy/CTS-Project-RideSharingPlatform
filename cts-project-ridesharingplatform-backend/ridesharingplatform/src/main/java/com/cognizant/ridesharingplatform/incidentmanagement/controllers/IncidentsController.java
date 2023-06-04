package com.cognizant.ridesharingplatform.incidentmanagement.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.cognizant.ridesharingplatform.incidentmanagement.entities.Incidents;
import com.cognizant.ridesharingplatform.incidentmanagement.entities.InvestigationDetails;
import com.cognizant.ridesharingplatform.incidentmanagement.service.impl.CannotReportIncidentException;
import com.cognizant.ridesharingplatform.incidentmanagement.service.impl.IncidentsServiceImp;
import com.cognizant.ridesharingplatform.incidentmanagement.service.impl.InvestigationDetailsServiceImpl;

import org.json.JSONObject;

import com.fasterxml.jackson.core.JsonProcessingException;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class IncidentsController {
	@Autowired
	IncidentsServiceImp incSerImp;
	@Autowired
	InvestigationDetailsServiceImpl investigationDetailsServiceImpl;

	@PostMapping("/api/incidents/report")
	String insertReport(@RequestBody Incidents incidents) throws CannotReportIncidentException {
		incSerImp.insertIncident(incidents);
		return "incident added";
	}

	@GetMapping("/api/incidents")
	List<Incidents> getIncidents() {
		return incSerImp.getIncidents();
	}

	@GetMapping("/api/incidents/{id}")
	Incidents getIncidnetsById(@PathVariable String id) {
		return incSerImp.getIncidentsById(id);
	}

	@PutMapping("/api/incidents/{id}/investigationreport")
	String investigationReport(@PathVariable String id, @RequestBody String Jsondata)
			throws JsonMappingException, JsonProcessingException {
		JSONObject jsnobject = new JSONObject(Jsondata);

		JSONObject investigationReportJson = jsnobject.getJSONObject("investigationDetails");
		ObjectMapper objectMapper = new ObjectMapper();

		InvestigationDetails investigationDetails = objectMapper.readValue(investigationReportJson.toString(),
				InvestigationDetails.class);
	
		Incidents incident = incSerImp.getIncidentsById(id);
		incident.setStatus("closed");
		incSerImp.updateIncidentById(incident);
		investigationDetails.setIncidents(incident);
		investigationDetailsServiceImpl.addInvestigationReport(investigationDetails);
		return "updated" + id;
	}
}
