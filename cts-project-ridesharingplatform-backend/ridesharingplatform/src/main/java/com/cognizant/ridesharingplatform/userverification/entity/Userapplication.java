package com.cognizant.ridesharingplatform.userverification.entity;


import com.cognizant.ridesharingplatform.userverification.dto.NewApplicationDto;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "userapplication")
public class Userapplication {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)

	private Long userId;
	
	@Column(unique=true)
	private String userName;
	
	@Column(unique=true)

	@Email(message = "Must be a valid Email !")
	@NotBlank(message = "Email is required !")
	@Size(min = 5, max = 256, message = "Email must be between 5 and 256 characters in length !")
	private String officialEmail;
	
	@Column(unique=true)
	@Size(min = 10,max = 10,message = "Phone number must be exactly 10 characters in length !")
	private String phoneNumber;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "companyId")
	public Companies companyId;
	
	private String designation;
	
	@Pattern(regexp = "Motorist|Rider|SecurityHead", message = "Invalid role !")
	private String role;
	
	private String employeeId;
	
	@Column(unique=true)
	@Size(min = 12,max = 12,message = "Aadhar number must be exactly 10 characters in length !")

	private String aadharNumber;
	
	@Pattern(regexp = "New|Approved|Rejected", message = "Invalid Status !")

	private String applicationStatus;

	public Userapplication(Long UserId, String UserName, String OfficialEmail, String PhoneNumber, Companies CompanyId,
			String Designation, String Role, String EmployeeId, String AadharNumber, String ApplicationStatus) {
		super();
		userId = UserId;
		userName = UserName;
		officialEmail = OfficialEmail;
		phoneNumber = PhoneNumber;
		companyId = CompanyId;
		designation = Designation;
		role = Role;
		employeeId = EmployeeId;
		aadharNumber = AadharNumber;
		applicationStatus = ApplicationStatus;

	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getOfficialEmail() {
		return officialEmail;
	}

	public void setOfficialEmail(String officialEmail) {
		this.officialEmail = officialEmail;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Companies getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Companies companyId) {
		this.companyId = companyId;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getAadharNumber() {
		return aadharNumber;
	}

	public void setAadharNumber(String aadharNumber) {
		this.aadharNumber = aadharNumber;
	}

	public String getApplicationStatus() {
		return applicationStatus;
	}

	public void setApplicationStatus(String applicationStatus) {
		this.applicationStatus = applicationStatus;
	}

	public Userapplication() {
		super();
		// TODO Auto-generated constructor stub
	}


	
}