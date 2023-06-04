package com.cognizant.ridesharingplatform.userverification.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.ridesharingplatform.userverification.dto.DrivinglicenseDto;
import com.cognizant.ridesharingplatform.userverification.dto.NewApplicationDto;
import com.cognizant.ridesharingplatform.userverification.dto.Response;
import com.cognizant.ridesharingplatform.userverification.dto.UpdateApplicationDto;
import com.cognizant.ridesharingplatform.userverification.entity.Drivinglicenses;
import com.cognizant.ridesharingplatform.userverification.entity.Userapplication;
import com.cognizant.ridesharingplatform.userverification.repository.DrivinglicensesRepository;
import com.cognizant.ridesharingplatform.userverification.repository.UserapplicationRepository;
import com.cognizant.ridesharingplatform.userverification.service.UserapplicationService;

@RequestMapping("/api")
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserapplicationController {

	@Autowired
	private UserapplicationService userserv;
	@Autowired
	private DrivinglicensesRepository repo;

	private ModelMapper modelMapper = new ModelMapper();

	@Autowired
	private UserapplicationRepository userrepo;
	

   
	@PostMapping("/applications/new")
	public Response newapplication(@RequestBody @Valid NewApplicationDto details) {
		
		   
		
		   Response data= userserv.newuser(details);
		   return data;
		    
	}
	
	@GetMapping("applications")
	public List<NewApplicationDto> getData() {
	
		return userserv.findByPendingApplications("New");


	}

	@GetMapping("/applications/{userId}")
	public NewApplicationDto getUserById(@PathVariable Long userId) {
		 	
     	NewApplicationDto data =userserv.getuserById(userId);
         
     	return data ;
		 
	}
	@PutMapping("/applications/approvereject")
	public ResponseEntity<String> updatestatus(@RequestBody @Valid UpdateApplicationDto status ) {
		Userapplication user=userserv.getById(status.getUserId());
		
		user.setApplicationStatus(status.getApplicationStatus());
		
		 userserv.createuser(user);
		 
	     return ResponseEntity.status(HttpStatus.OK).body("Update successful");
		
	}
	@PostMapping("/login")
	public Response login(@RequestBody @Valid String email) {

		 
	    Userapplication user = userrepo.findByOfficialEmail(email);
    if (user == null) {
    	    	return new Response(400,HttpStatus.BAD_REQUEST,null);
    } if (!user.getRole().equals("SecurityHead")) {
    	return new Response(400,HttpStatus.BAD_REQUEST,null);
	    }
        Map<String, Object> userdata = new HashMap<>();
        userdata.put("Id", user.getUserId());
        userdata.put("email", user.getOfficialEmail());
        userdata.put("name",user.getUserName());

    	return new Response(200,HttpStatus.OK,null);

	}
}

	

