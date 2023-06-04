package com.cognizant.ridesharingplatform.incidentmanagement.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.ridesharingplatform.incidentmanagement.entities.InvestigationDetails;

public interface InvestigationDetailsRepo extends JpaRepository<InvestigationDetails, Integer> {

}
