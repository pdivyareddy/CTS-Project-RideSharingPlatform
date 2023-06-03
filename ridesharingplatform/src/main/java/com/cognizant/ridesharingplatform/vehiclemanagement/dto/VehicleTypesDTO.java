package com.cognizant.ridesharingplatform.vehiclemanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VehicleTypesDTO {

	private int id;

	private String type;

	private int maxPassengersAllowed;

	private int farePerKM;

	@Override
	public String toString() {
		return "VehicleTypesDTO [id=" + id + ", type=" + type + ", maxPassengersAllowed=" + maxPassengersAllowed
				+ ", farePerKM=" + farePerKM + "]";
	}

}
