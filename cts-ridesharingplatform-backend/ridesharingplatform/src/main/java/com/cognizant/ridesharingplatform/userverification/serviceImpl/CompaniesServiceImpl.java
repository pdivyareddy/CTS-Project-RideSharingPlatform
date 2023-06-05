package com.cognizant.ridesharingplatform.userverification.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

import com.cognizant.ridesharingplatform.userverification.dto.CompaniesDto;
import com.cognizant.ridesharingplatform.userverification.dto.NewApplicationDto;
import com.cognizant.ridesharingplatform.userverification.entity.Companies;
import com.cognizant.ridesharingplatform.userverification.repository.CompaniesRepository;
import com.cognizant.ridesharingplatform.userverification.service.CompaniesService;

@Service
public class CompaniesServiceImpl implements CompaniesService {

	@Autowired
	private CompaniesRepository compRepo;

	private ModelMapper modelMapper = new ModelMapper();

	@Override
	public List<Companies> findByBuildingName(String name) {
//	List<CompaniesDto> result= compRepo.findByBuildingName(name).stream().map(Companies -> modelMapper.map(Companies, CompaniesDto.class)).collect(Collectors.toList());
		return compRepo.findByBuildingName(name);
	}
 

//	@Override
//	public List<CompaniesDto> findByBuildingName(String buildname) {
//		List<CompaniesDto> company= compRepo.findByBuildingName(buildname).stream().map(Companies -> modelMapper.map(Companies, CompaniesDto.class)).collect(Collectors.toList());
//	    return company;
//
//	}

}
