package com.cognizant.ridesharingplatform.vehiclemanagement.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "vehicledetails")
public class VehicleDetails {

	@Id
	@Column(name = "registrationno", length = 10)
	private String registrationNo;

	@NotNull
	@Column(name = "rtoname")
	private String rtoName;

	@NotNull
	@Column(name = "registrationdate")
	private Date registrationDate;

	@NotNull
	@FutureOrPresent(message = "must not be a past date")
	@Column(name = "registrationexpireson")
	private Date registrationExpiresOn;

	@NotNull
	@Column(name = "rcdocurl")
	private String rcDocURL;

	@NotNull
	@Column(name = "insurancecompanyname")
	private String insuranceCompanyName;

	@NotNull
	@Column(name = "insuranceno")
	private int insuranceNo;

	@NotNull
	@Column(name = "insurancedon")
	private Date insurancedOn;

	@NotNull
	@FutureOrPresent(message = "must not be a past date")
	@Column(name = "insuranceexpireson")
	private Date insuranceExpiresOn;

	@NotNull
	@Column(name = "insurancecertificatedocurl")
	private String insuranceCertificateDOCURL;

	@NotNull
	@Column(name = "puccertificateno")
	private int pucCertificateNo;

	@NotNull
	@Column(name = "pucissuedon")
	private Date pucIssuedOn;

	@NotNull
	@Column(name = "pucvaliduntil")
	@FutureOrPresent(message = "must not be a past date")
	private Date pucValidUntil;

	@NotNull
	@Column(name = "pucdocurl")
	private String pucDOCURL;

	public VehicleDetails() {

	}

	public VehicleDetails(String registrationNo, String rtoName, Date registrationDate, Date registrationExpiresOn,
			String rcDocURL, String insuranceCompanyName, int insuranceNo, Date insurancedOn, Date insuranceExpiresOn,
			String insuranceCertificateDOCURL, int pucCertificateNo, Date pucIssuedOn, Date pucValidUntil,
			String pucDOCURL) {
		this.registrationNo = registrationNo;
		this.rtoName = rtoName;
		this.registrationDate = registrationDate;
		this.registrationExpiresOn = registrationExpiresOn;
		this.rcDocURL = rcDocURL;
		this.insuranceCompanyName = insuranceCompanyName;
		this.insuranceNo = insuranceNo;
		this.insurancedOn = insurancedOn;
		this.insuranceExpiresOn = insuranceExpiresOn;
		this.insuranceCertificateDOCURL = insuranceCertificateDOCURL;
		this.pucCertificateNo = pucCertificateNo;
		this.pucIssuedOn = pucIssuedOn;
		this.pucValidUntil = pucValidUntil;
		this.pucDOCURL = pucDOCURL;
	}

	public String getRegistrationNo() {
		return registrationNo;
	}

	public void setRegistrationNo(String registrationNo) {
		this.registrationNo = registrationNo;
	}

	public String getRTOName() {
		return rtoName;
	}

	public void setRTOName(String rTOName) {
		this.rtoName = rTOName;
	}

	public Date getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}

	public Date getRegistrationExpiresOn() {
		return registrationExpiresOn;
	}

	public void setRegistrationExpiresOn(Date registrationExpiresOn) {
		this.registrationExpiresOn = registrationExpiresOn;
	}

	public String getRCDocURL() {
		return rcDocURL;
	}

	public void setRCDocURL(String rCDocURL) {
		this.rcDocURL = rCDocURL;
	}

	public String getInsuranceCompanyName() {
		return insuranceCompanyName;
	}

	public void setInsuranceCompanyName(String insuranceCompanyName) {
		this.insuranceCompanyName = insuranceCompanyName;
	}

	public @NotNull int getInsuranceNo() {
		return insuranceNo;
	}

	public void setInsuranceNo(int insuranceNo) {
		this.insuranceNo = insuranceNo;
	}

	public Date getInsurancedOn() {
		return insurancedOn;
	}

	public void setInsurancedOn(Date insurancedOn) {
		this.insurancedOn = insurancedOn;
	}

	public Date getInsuranceExpiresOn() {
		return insuranceExpiresOn;
	}

	public void setInsuranceExpiresOn(Date insuranceExpiresOn) {
		this.insuranceExpiresOn = insuranceExpiresOn;
	}

	public String getInsuranceCertificateDOCURL() {
		return insuranceCertificateDOCURL;
	}

	public void setInsuranceCertificateDOCURL(String insuranceCertificateDOCURL) {
		this.insuranceCertificateDOCURL = insuranceCertificateDOCURL;
	}

	public int getPUCCertificateNo() {
		return pucCertificateNo;
	}

	public void setPUCCertificateNo(int pUCCertificateNo) {
		this.pucCertificateNo = pUCCertificateNo;
	}

	public Date getPUCIssuedOn() {
		return pucIssuedOn;
	}

	public void setPUCIssuedOn(Date pUCIssuedOn) {
		this.pucIssuedOn = pUCIssuedOn;
	}

	public Date getPUCValidUntil() {
		return pucValidUntil;
	}

	public void setPUCValidUntil(Date pUCValidUntil) {
		this.pucValidUntil = pUCValidUntil;
	}

	public String getPUCDOCURL() {
		return pucDOCURL;
	}

	public void setPUCDOCURL(String pUCDOCURL) {
		this.pucDOCURL = pUCDOCURL;
	}

	@Override
	public String toString() {
		return "VehicleDetails [RegistrationNo=" + registrationNo + ", RTOName=" + rtoName + ", RegistrationDate="
				+ registrationDate + ", RegistrationExpiresOn=" + registrationExpiresOn + ", RCDocURL=" + rcDocURL
				+ ", InsuranceCompanyName=" + insuranceCompanyName + ", InsuranceNo=" + insuranceNo + ", InsurancedOn="
				+ insurancedOn + ", InsuranceExpiresOn=" + insuranceExpiresOn + ", InsuranceCertificateDOCURL="
				+ insuranceCertificateDOCURL + ", PUCCertificateNo=" + pucCertificateNo + ", PUCIssuedOn=" + pucIssuedOn
				+ ", PUCValidUntil=" + pucValidUntil + ", PUCDOCURL=" + pucDOCURL + "]";
	}

}
