package com.cognizant.ridesharingplatform.incidentmanagement.payloads;

public class IncidentTypesDto {
	private int  Id;

	private int  Type;
    
    
	private int  expectedSLAInDays;


	public int getId() {
		return Id;
	}


	public void setId(int id) {
		Id = id;
	}


	public int getType() {
		return Type;
	}


	public void setType(int type) {
		Type = type;
	}


	public int getExpectedSLAInDays() {
		return expectedSLAInDays;
	}


	public void setExpectedSLAInDays(int expectedSLAInDays) {
		this.expectedSLAInDays = expectedSLAInDays;
	}
    
  


}
