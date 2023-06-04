package com.cognizant.ridesharingplatform.incidentmanagement.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class IncidentTypes {
			@javax.persistence.Id
            @Column(name="Id",length=10)
			private int  Id;

            @Column(name="Type",length=10)
			private int  Type;
            
            @Column(name="expectedSLAInDays",length=10)
			private int  expectedSLAInDays;
            
            
			@OneToMany(mappedBy="incidentTypeId")
			private List<Incidents> incidents;

			
			

			public int getId() {
				return Id;
			}

			public void setId(int id) {
				Id = id;
			}

			public int getType() {
				return Type;
			}

			public void setType(int type) {
				Type = type;
			}

			public int getExpectedSLAInDays() {
				return expectedSLAInDays;
			}

			public void setExpectedSLAInDays(int expectedSLAInDays) {
				this.expectedSLAInDays = expectedSLAInDays;
			}

			public List<Incidents> getIncidents() {
				return incidents;
			}

			public void setIncidents(List<Incidents> incidents) {
				this.incidents = incidents;
			}

			public IncidentTypes() {
				super();
				// TODO Auto-generated constructor stub
			}
}
