package com.cognizant.ridesharingplatform.incidentmanagement.payloads;

import java.time.LocalDate;

public class IncidentsDto {

	private String incidentID;

	private LocalDate incidentDate;

	private LocalDate reportDate;

	private int incidentReportsByUserId;

	private int incidentTypeId;

	private LocalDate resolutionETA;

	private int investigatedByUserId;

	private String incidentSummary;

	private String incidentDetails;

	private int bookingId;

	private String status = "pending";

	public String getIncidentID() {
		return incidentID;
	}

	public void setIncidentID(String incidentID) {
		this.incidentID = incidentID;
	}

	public LocalDate getIncidentDate() {
		return incidentDate;
	}

	public void setIncidentDate(LocalDate incidentDate) {
		this.incidentDate = incidentDate;
	}

	public LocalDate getReportDate() {
		return reportDate;
	}

	public void setReportDate(LocalDate reportDate) {
		this.reportDate = reportDate;
	}

	public int getIncidentReportsByUserId() {
		return incidentReportsByUserId;
	}

	public void setIncidentReportsByUserId(int incidentReportsByUserId) {
		this.incidentReportsByUserId = incidentReportsByUserId;
	}

	public int getIncidentTypeId() {
		return incidentTypeId;
	}

	public void setIncidentTypeId(int incidentTypeId) {
		this.incidentTypeId = incidentTypeId;
	}

	public LocalDate getResolutionETA() {
		return resolutionETA;
	}

	public void setResolutionETA(LocalDate resolutionETA) {
		this.resolutionETA = resolutionETA;
	}

	public int getInvestigatedByUserId() {
		return investigatedByUserId;
	}

	public void setInvestigatedByUserId(int investigatedByUserId) {
		this.investigatedByUserId = investigatedByUserId;
	}

	public String getIncidentSummary() {
		return incidentSummary;
	}

	public void setIncidentSummary(String incidentSummary) {
		this.incidentSummary = incidentSummary;
	}

	public String getIncidentDetails() {
		return incidentDetails;
	}

	public void setIncidentDetails(String incidentDetails) {
		this.incidentDetails = incidentDetails;
	}

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	

}