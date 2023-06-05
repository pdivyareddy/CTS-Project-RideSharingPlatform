package com.cognizant.ridesharingplatform.userverification.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

import com.cognizant.ridesharingplatform.userverification.dto.CompaniesDto;
import com.cognizant.ridesharingplatform.userverification.entity.Companies;
import com.cognizant.ridesharingplatform.userverification.service.CompaniesService;


@RequestMapping("/api")
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CompaniesController {
	
	@Autowired
	private CompaniesService companiesService;
	@GetMapping("/home")
	public String home() {
		return "heloo world";
	}
	@GetMapping("/companies")
	public List<Companies> companies() {

		return companiesService.findByBuildingName("Raheja IT park");
		
}

}
