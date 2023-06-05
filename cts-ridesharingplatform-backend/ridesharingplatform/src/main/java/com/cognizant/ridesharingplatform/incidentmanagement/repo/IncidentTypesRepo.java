package com.cognizant.ridesharingplatform.incidentmanagement.repo;


import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.ridesharingplatform.incidentmanagement.entities.IncidentTypes;

public interface IncidentTypesRepo extends JpaRepository<IncidentTypes, Integer>{

	
}
