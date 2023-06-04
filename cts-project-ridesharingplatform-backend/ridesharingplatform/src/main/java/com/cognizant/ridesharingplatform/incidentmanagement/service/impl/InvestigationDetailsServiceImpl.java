package com.cognizant.ridesharingplatform.incidentmanagement.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.ridesharingplatform.incidentmanagement.entities.InvestigationDetails;
import com.cognizant.ridesharingplatform.incidentmanagement.repo.InvestigationDetailsRepo;
import com.cognizant.ridesharingplatform.incidentmanagement.service.InvestigationDetailsService;
@Service
public class InvestigationDetailsServiceImpl implements InvestigationDetailsService {
	@Autowired
InvestigationDetailsRepo investigationDetailsRepo;
	@Override
	public InvestigationDetails addInvestigationReport(InvestigationDetails investigationDetails) {
		// TODO Auto-generated method stub
		return investigationDetailsRepo.save(investigationDetails);
	}
	
}
