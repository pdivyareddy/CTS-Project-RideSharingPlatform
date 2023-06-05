package com.cognizant.ridesharingplatform.userverification.dto;



public class UserapplicationDto {
	
	private Long userId;
	private String userName;
	public UserapplicationDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserapplicationDto(Long userId, String userName, String officialEmail, String phoneNumber,
			String designation, String role, String employeeId, String aadharNumber, String applicationStatus) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.officialEmail = officialEmail;
		this.phoneNumber = phoneNumber;
		this.designation = designation;
		this.role = role;
		this.employeeId = employeeId;
		this.aadharNumber = aadharNumber;
		this.applicationStatus = applicationStatus;
	}
	private String officialEmail;
	private String phoneNumber;
	private String designation;
	private String role;
	private String employeeId;
	private String aadharNumber;
    private String applicationStatus;
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


}
