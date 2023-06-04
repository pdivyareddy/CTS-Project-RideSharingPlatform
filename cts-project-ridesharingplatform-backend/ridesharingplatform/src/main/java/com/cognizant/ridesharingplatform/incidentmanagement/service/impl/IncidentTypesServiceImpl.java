package com.cognizant.ridesharingplatform.incidentmanagement.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.ridesharingplatform.incidentmanagement.entities.IncidentTypes;
import com.cognizant.ridesharingplatform.incidentmanagement.payloads.IncidentTypesDto;
import com.cognizant.ridesharingplatform.incidentmanagement.repo.IncidentTypesRepo;
import com.cognizant.ridesharingplatform.incidentmanagement.service.IncidentTypesService;
@Service
public class IncidentTypesServiceImpl implements IncidentTypesService {
	@Autowired
	private IncidentTypesRepo incidentTypesRepo;

	private ModelMapper modelMapper=new ModelMapper();
	

	@Override
	public List<IncidentTypesDto> getIncidentTypes() {
		List<IncidentTypes> incidentTypes = this.incidentTypesRepo.findAll();
		List<IncidentTypesDto> incidentTypesDto = incidentTypes.stream().map((i)->this.modelMapper.map(i,IncidentTypesDto.class)).collect(Collectors.toList());
		
		return incidentTypesDto ;
	}

}
