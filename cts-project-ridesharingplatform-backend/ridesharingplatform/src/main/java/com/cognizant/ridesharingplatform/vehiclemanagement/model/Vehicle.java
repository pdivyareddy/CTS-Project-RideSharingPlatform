package com.cognizant.ridesharingplatform.vehiclemanagement.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "vehicles")
public class Vehicle {

	@Id
	@Column(name = "registrationno", length = 10)
	private String registrationNo;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "registrationno")
	private VehicleDetails vehicledetails;

	@NotNull
	@Column(name = "belongstouserid")
	private int belongsToUserId;

	@ManyToOne
	@JoinColumn(name = "vehicletypeid")
	private VehicleTypes vehicletypes;

	@NotNull
	@Pattern(regexp = "^(pending|approved|rejected)$")
	@Column(name = "inspectionstatus")
	private String inspectionStatus;

	@Column(name = "inspectedbyuserid")
	private int inspectedByUserId;

	@Column(name = "inspectedon")
	private Date inspectedOn;

	public Vehicle() {

	}

	public Vehicle(String registrationNo, VehicleTypes vehicleTypes, int belongsToUserId, VehicleDetails vehicleDetails,
			String inspectionStatus, int inspectedByUserId, Date inspectedOn) {
		this.registrationNo = registrationNo;
		this.vehicletypes = vehicleTypes;
		this.belongsToUserId = belongsToUserId;
		this.vehicledetails = vehicleDetails;
		this.inspectionStatus = inspectionStatus;
		this.inspectedByUserId = inspectedByUserId;
		this.inspectedOn = inspectedOn;
	}

	public String getRegistrationNo() {
		return registrationNo;
	}

	public void setRegistrationNo(String registrationNo) {
		this.registrationNo = registrationNo;
	}

	public int getBelongsToUserId() {
		return belongsToUserId;
	}

	public void setBelongsToUserId(int belongsToUserId) {
		this.belongsToUserId = belongsToUserId;
	}

	public String getInspectionStatus() {
		return inspectionStatus;
	}

	public void setInspectionStatus(String inspectionStatus) {
		this.inspectionStatus = inspectionStatus;
	}

	public int getInspectedByUserId() {
		return inspectedByUserId;
	}

	public void setInspectedByUserId(int inspectedByUserId) {
		this.inspectedByUserId = inspectedByUserId;
	}

	public Date getInspectedOn() {
		return inspectedOn;
	}

	public void setInspectedOn(Date inspectedOn) {
		this.inspectedOn = inspectedOn;
	}

	public VehicleTypes getVehicleTypes() {
		return vehicletypes;
	}

	public void setVehicleTypes(VehicleTypes vehicleTypes) {
		this.vehicletypes = vehicleTypes;
	}

	public VehicleDetails getVehicleDetails() {
		return vehicledetails;
	}

	public void setVehicleDetails(VehicleDetails vehicleDetails) {
		this.vehicledetails = vehicleDetails;
	}

	@Override
	public String toString() {
		return "Vehicle [registrationNo=" + registrationNo + ", vehicledetails=" + vehicledetails + ", belongsToUserId="
				+ belongsToUserId + ", vehicletypes=" + vehicletypes + ", inspectionStatus=" + inspectionStatus
				+ ", inspectedByUserId=" + inspectedByUserId + ", inspectedOn=" + inspectedOn + "]";
	}

}
