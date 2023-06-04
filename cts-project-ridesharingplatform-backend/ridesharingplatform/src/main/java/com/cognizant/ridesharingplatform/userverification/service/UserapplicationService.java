package com.cognizant.ridesharingplatform.userverification.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.ridesharingplatform.userverification.dto.NewApplicationDto;
import com.cognizant.ridesharingplatform.userverification.dto.Response;
import com.cognizant.ridesharingplatform.userverification.entity.Userapplication;
import com.cognizant.ridesharingplatform.userverification.repository.UserapplicationRepository;


public interface UserapplicationService {

	List<NewApplicationDto> findByPendingApplications(String status);
	Userapplication getById(Long id);
	NewApplicationDto getuserById(Long userId);
	Userapplication createuser(Userapplication user);
	Response newuser(NewApplicationDto details);
	

//	@Autowired
//	private UserapplicationRepository userApplicationRepository;
//
//	public boolean createApplication(Userapplication application) {
//		userApplicationRepository.save(application);
//		Optional<Userapplication> check = userApplicationRepository.findById(application.getUserId());
//		if (check.isPresent()) {
//			return true;
//		}
//		return false;
//	}
////return pending application userid

	
}