package com.cognizant.ridesharingplatform.vehiclemanagement.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VehicleDTO {

	private String registrationNo;

	private VehicleDetailsDTO vehicledetails;

	private int belongsToUserId;

	private VehicleTypesDTO vehicletypes;

	private String inspectionStatus;

	private int inspectedByUserId;

	private Date inspectedOn;

	@Override
	public String toString() {
		return "VehicleDTO [registrationNo=" + registrationNo + ", vehicledetails=" + vehicledetails
				+ ", belongsToUserId=" + belongsToUserId + ", vehicletypes=" + vehicletypes + ", inspectionStatus="
				+ inspectionStatus + ", inspectedByUserId=" + inspectedByUserId + ", inspectedOn=" + inspectedOn + "]";
	}

}
