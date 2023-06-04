package com.cognizant.ridesharingplatform.vehiclemanagement.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VehicleDetailsDTO {

	private String registrationNo;

	private String rtoName;

	private Date registrationDate;

	private Date registrationExpiresOn;

	private String rcDocURL;

	private String insuranceCompanyName;

	private int insuranceNo;

	private Date insurancedOn;

	private Date insuranceExpiresOn;

	private String insuranceCertificateDOCURL;
	
	private int pucCertificateNo;
	
	private Date pucIssuedOn;

	private Date pucValidUntil;
	
	private String pucDOCURL;

	@Override
	public String toString() {
		return "VehicleDetailsDTO [registrationNo=" + registrationNo + ", rtoname=" + rtoName + ", registrationDate="
				+ registrationDate + ", registrationExpiresOn=" + registrationExpiresOn + ", rcdocURL=" + rcDocURL
				+ ", insuranceCompanyName=" + insuranceCompanyName + ", insuranceNo=" + insuranceNo + ", insurancedOn="
				+ insurancedOn + ", insuranceExpiresOn=" + insuranceExpiresOn + ", insuranceCertificateDOCURL="
				+ insuranceCertificateDOCURL + ", puccertificateNo=" + pucCertificateNo + ", pucissuedOn=" + pucIssuedOn
				+ ", pucvalidUntil=" + pucValidUntil + ", pucdocurl=" + pucDOCURL + "]";
	}

}
