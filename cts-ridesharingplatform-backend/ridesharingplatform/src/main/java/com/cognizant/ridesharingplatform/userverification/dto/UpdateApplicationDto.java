package com.cognizant.ridesharingplatform.userverification.dto;


public class UpdateApplicationDto {

	
	private Long userId;
	private String applicationStatus;
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getApplicationStatus() {
		return applicationStatus;
	}
	public void setApplicationStatus(String applicationStatus) {
		this.applicationStatus = applicationStatus;
	}
	public UpdateApplicationDto(Long userId, String applicationStatus) {
		super();
		this.userId = userId;
		this.applicationStatus = applicationStatus;
	}
	public UpdateApplicationDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	

}
