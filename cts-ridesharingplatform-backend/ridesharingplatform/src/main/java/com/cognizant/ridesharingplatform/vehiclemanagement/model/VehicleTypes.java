package com.cognizant.ridesharingplatform.vehiclemanagement.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "vehicletypes")
public class VehicleTypes {

	@Id
	@Column(name = "id")
	private int id;

	@NotNull
	@Column(name = "type")
	private String type;

	@NotNull
	@Column(name = "maxpassengersallowed")
	private int maxPassengersAllowed;

	@NotNull
	@Column(name = "fareperkm")
	private int farePerKM;

	@OneToMany(mappedBy = "vehicletypes")
	private List<Vehicle> vehicle;

	public VehicleTypes() {

	}

	public VehicleTypes(int iD, String type, int maxPassengersAllowed, int farePerKM) {
		this.id = iD;
		this.type = type;
		this.maxPassengersAllowed = maxPassengersAllowed;
		this.farePerKM = farePerKM;
	}

	public int getID() {
		return id;
	}

	public void setID(int iD) {
		this.id = iD;
	}

	public String getType() {
		return type;
	}

	public void setType(String Type) {
		this.type = Type;
	}

	public int getMaxPassengersAllowed() {
		return maxPassengersAllowed;
	}

	public void setMaxPassengersAllowed(int maxPassengersAllowed) {
		this.maxPassengersAllowed = maxPassengersAllowed;
	}

	public int getFarePerKM() {
		return farePerKM;
	}

	public void setFarePerKM(int farePerKM) {
		this.farePerKM = farePerKM;
	}

	@JsonIgnore
	public List<Vehicle> getVehicle() {
		return vehicle;
	}

	public void setVehicle(List<Vehicle> vehicle) {
		this.vehicle = vehicle;
	}

	@Override
	public String toString() {
		return "VehicleTypes [ID=" + id + ", Type=" + type + ", MaxPassengersAllowed=" + maxPassengersAllowed
				+ ", FarePerKM=" + farePerKM + "]";
	}

}
