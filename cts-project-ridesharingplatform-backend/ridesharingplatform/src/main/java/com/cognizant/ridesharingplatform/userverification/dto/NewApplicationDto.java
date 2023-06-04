package com.cognizant.ridesharingplatform.userverification.dto;

import com.cognizant.ridesharingplatform.userverification.entity.Companies;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewApplicationDto {

	private Long userId;
	private String userName;
	private String officialEmail;
	private String phoneNumber;
	private String designation;
	private String role;
	private String employeeId;
	private String aadharNumber;
	private String applicationStatus;
	private Companies company;
	private DrivinglicenseDto drivinglicense;

}
