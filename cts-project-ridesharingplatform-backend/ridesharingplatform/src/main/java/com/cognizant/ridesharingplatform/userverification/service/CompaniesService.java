package com.cognizant.ridesharingplatform.userverification.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cognizant.ridesharingplatform.userverification.dto.CompaniesDto;
import com.cognizant.ridesharingplatform.userverification.entity.Companies;

public interface CompaniesService {

	public List<Companies> findByBuildingName(String name);


}
