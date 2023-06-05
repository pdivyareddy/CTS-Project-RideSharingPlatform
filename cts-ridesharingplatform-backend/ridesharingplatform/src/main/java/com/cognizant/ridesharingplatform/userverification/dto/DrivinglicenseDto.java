package com.cognizant.ridesharingplatform.userverification.dto;

import java.sql.Date;
public class DrivinglicenseDto {
public DrivinglicenseDto() {
		super();
		// TODO Auto-generated constructor stub
	}
public DrivinglicenseDto(String licenseNo, Date expirationDate, String rTA, String allowedVehicles) {
		super();
		this.licenseNo = licenseNo;
		this.expirationDate = expirationDate;
		this.rTA = rTA;
		this.allowedVehicles = allowedVehicles;
	}
//	private Long userId;
	private String licenseNo;
	private Date expirationDate;
	private String rTA;
	private String allowedVehicles;
	public String getrTA() {
		return rTA;
	}
	public void setrTA(String rTA) {
		this.rTA = rTA;
	}
	public String getLicenseNo() {
		return licenseNo;
	}
	public void setLicenseNo(String licenseNo) {
		this.licenseNo = licenseNo;
	}
	public Date getExpirationDate() {
		return expirationDate;
	}
	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}
	public String getAllowedVehicles() {
		return allowedVehicles;
	}
	public void setAllowedVehicles(String allowedVehicles) {
		this.allowedVehicles = allowedVehicles;
	}
	
	


}
