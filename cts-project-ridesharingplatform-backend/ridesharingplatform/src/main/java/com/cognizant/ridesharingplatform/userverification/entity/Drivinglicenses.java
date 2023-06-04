package com.cognizant.ridesharingplatform.userverification.entity;

import java.util.Date;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Future;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


@Entity
public class Drivinglicenses {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)

	private Long id;
	@OneToOne // (cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	public Userapplication userId;
	
	 @Pattern(regexp = "[A-Za-z]{3}\\d{4}[A-Za-z]{3}", message = "Invalid license number format")
	 @Size(min = 10, max = 10, message = "License number must be 10 characters")
	private String licenseNo;
	 
    @Future(message = "Expiration date must not be a past date")

	@Temporal(TemporalType.DATE)
	private Date expirationDate;
    
	@Size(min = 10,max = 20,message = "rTA contains length 10 to 20 !")
	private String rTA;
	
	private String allowedVehicles;

	public Drivinglicenses() {
		super();
	}

	public Drivinglicenses(Long Id, Userapplication UserId, String LicenseNo, Date ExpirationDate, String RTA,
			String AllowedVehicles) {
		super();
		id = Id;
		userId = UserId;
		licenseNo = LicenseNo;
		expirationDate = ExpirationDate;
		rTA = RTA;
		allowedVehicles = AllowedVehicles;

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Userapplication getUserId() {
		return userId;
	}

	public void setUserId(Userapplication userId) {
		this.userId = userId;
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

	public String getrTA() {
		return rTA;
	}

	public void setrTA(String rTA) {
		this.rTA = rTA;
	}

	public String getAllowedVehicles() {
		return allowedVehicles;
	}

	public void setAllowedVehicles(String allowedVehicles) {
		this.allowedVehicles = allowedVehicles;
	}

	public boolean isExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	
}