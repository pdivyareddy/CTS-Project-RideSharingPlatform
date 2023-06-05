package com.cognizant.ridesharingplatform.userverification.dto;

public class CompaniesDto {
	
	private Long id;

    public CompaniesDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CompaniesDto(Long id, String companyName, String buildingName) {
		super();
		this.id = id;
		this.companyName = companyName;
		this.buildingName = buildingName;
	}
	private  String companyName;
	private String buildingName;
	public Long getId() {
		// TODO Auto-generated method stub
		return null;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getBuildingName() {
		return buildingName;
	}
	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}
	public void setId(Long id) {
		this.id = id;
	}

}
