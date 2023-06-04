package com.cognizant.ridesharingplatform.userverification.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Entity
public class Companies {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String companyName;
	private String buildingName;
	private String securityInchargeName;
	
	@Column(nullable=false)
	@Size(min = 10,max = 10,message = " securityHelpDeskNumber must be exactly 10 characters in length !")

	private String securityHelpDeskNumber;

	public Companies() {
		super();
	}

	public Companies(Long Id, String CompanyName, String BuildingName, String SecurityInchargeName,
			String SecurityHelpDeskNumber) {
		super();
		id = Id;
		companyName = CompanyName;
		buildingName = BuildingName;
		securityInchargeName = SecurityInchargeName;
		securityHelpDeskNumber = SecurityHelpDeskNumber;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getSecurityInchargeName() {
		return securityInchargeName;
	}

	public void setSecurityInchargeName(String securityInchargeName) {
		this.securityInchargeName = securityInchargeName;
	}

	public String getSecurityHelpDeskNumber() {
		return securityHelpDeskNumber;
	}

	public void setSecurityHelpDeskNumber(String securityHelpDeskNumber) {
		this.securityHelpDeskNumber = securityHelpDeskNumber;
	}
}
