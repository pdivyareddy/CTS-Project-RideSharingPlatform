package com.cognizant.ridesharingplatform.userverification.serviceImpl;

import java.util.*;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.cognizant.ridesharingplatform.userverification.dto.DrivinglicenseDto;
import com.cognizant.ridesharingplatform.userverification.dto.NewApplicationDto;
import com.cognizant.ridesharingplatform.userverification.dto.Response;
import com.cognizant.ridesharingplatform.userverification.entity.Companies;
import com.cognizant.ridesharingplatform.userverification.entity.Drivinglicenses;
import com.cognizant.ridesharingplatform.userverification.entity.Userapplication;
import com.cognizant.ridesharingplatform.userverification.repository.CompaniesRepository;
import com.cognizant.ridesharingplatform.userverification.repository.DrivinglicensesRepository;
import com.cognizant.ridesharingplatform.userverification.repository.UserapplicationRepository;
import com.cognizant.ridesharingplatform.userverification.service.UserapplicationService;

@Service
public class UserapplicationServiceImpl implements UserapplicationService {
	@Autowired
	private UserapplicationRepository userrepo;
	
	private ModelMapper modelMapper = new ModelMapper();

 
	@Autowired
	private CompaniesRepository comrepo;
	@Autowired
	private DrivinglicensesRepository drivingrepo;


	@Override
	public List<NewApplicationDto> findByPendingApplications(String status) {
		List<NewApplicationDto> user= userrepo.findByPendingApplications(status).stream().map(Userapplication -> modelMapper.map(Userapplication, NewApplicationDto.class)).collect(Collectors.toList());
	    
		
		return user;
		
	}

	

	@Override
	public Userapplication getById(Long id) {
		return userrepo.findByUserId(id);
	}


	@Override
	public NewApplicationDto getuserById(Long userId) {
		Userapplication data=userrepo.findByUserId(userId);
	    
		NewApplicationDto user=modelMapper.map(data,NewApplicationDto.class);
		Drivinglicenses license=drivingrepo.getuserById(userId);
		if(license!=null) {
		user.setDrivinglicense(modelMapper.map(license,DrivinglicenseDto.class ));
		}
		else {
		user.setDrivinglicense(null);}
	
		
		return user;
	}
  	
	




	@Override
	public Userapplication createuser(Userapplication user) {
		// TODO Auto-generated method stub
		return userrepo.save(user);

	}



	@Override
	public Response newuser(NewApplicationDto details) {
		Userapplication data=modelMapper.map(details, Userapplication.class);
      if(checkname(data.getUserName())) {
      	return new Response(400,HttpStatus.BAD_GATEWAY,"Username already exist");
      }
      if(checkemail(data.getOfficialEmail())) {
      	return new Response(400,HttpStatus.BAD_REQUEST,"Email already exist");
	}if(checkmobile(data.getPhoneNumber())) {
    	return new Response(400,HttpStatus.BAD_REQUEST,"Mobileno already exist ,Please provide other number");
	}
      Companies comp=comrepo.findById(details.getCompany().getId()).get();
      
	  data.setCompanyId(comp);
	  userrepo.save(data);
	  DrivinglicenseDto dto=modelMapper.map(details.getDrivinglicense(), DrivinglicenseDto.class);
      Drivinglicenses license=modelMapper.map(dto, Drivinglicenses.class);
      license.setUserId(data);
      drivingrepo.save(license);
	  
  	return new Response(200,HttpStatus.OK,"Application submitted successfull");
	  

}
	boolean checkname(String name) {
		  Userapplication user=userrepo.findByUserName(name);
		  if(user!=null) {
			  return true;
		  }
		  return false;
	  }
	  boolean checkemail(String email) {
		  Userapplication user=userrepo.findFirstByOfficialEmail(email);
		  if(user!=null) {
			  return true;
		  }
		  return false;
	  }
	  boolean checkmobile(String mobile) {
		  Userapplication user=userrepo.findByPhoneNumber(mobile);
		  if(user!=null) {
			  return true;
		  }
		  return false;
	  }
		 

		


}