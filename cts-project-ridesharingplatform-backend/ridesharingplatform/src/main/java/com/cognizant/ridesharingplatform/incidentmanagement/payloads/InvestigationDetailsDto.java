package com.cognizant.ridesharingplatform.incidentmanagement.payloads;

import java.time.LocalDate;

import com.cognizant.ridesharingplatform.incidentmanagement.entities.Incidents;

public class InvestigationDetailsDto {
	
	private int ID;
	
	private String findings;
	
	
	private String Suggestions;
	
	private LocalDate investigationDate;
	
	
	private  Incidents incidents;


	public int getID() {
		return ID;
	}


	public void setID(int iD) {
		ID = iD;
	}


	public String getFindings() {
		return findings;
	}


	public void setFindings(String findings) {
		this.findings = findings;
	}


	public String getSuggestions() {
		return Suggestions;
	}


	public void setSuggestions(String suggestions) {
		Suggestions = suggestions;
	}


	public LocalDate getInvestigationDate() {
		return investigationDate;
	}


	public void setInvestigationDate(LocalDate investigationDate) {
		this.investigationDate = investigationDate;
	}


	public Incidents getIncidents() {
		return incidents;
	}


	public void setIncidents(Incidents incidents) {
		this.incidents = incidents;
	}


}
