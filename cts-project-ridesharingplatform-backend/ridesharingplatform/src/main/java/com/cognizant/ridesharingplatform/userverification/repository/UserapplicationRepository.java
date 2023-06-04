package com.cognizant.ridesharingplatform.userverification.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cognizant.ridesharingplatform.userverification.dto.NewApplicationDto;
import com.cognizant.ridesharingplatform.userverification.dto.UserapplicationDto;
import com.cognizant.ridesharingplatform.userverification.entity.Userapplication;

@Repository
public interface UserapplicationRepository extends JpaRepository<Userapplication, Long> {

	@Query(value = "SELECT * FROM UserApplication WHERE application_status = :appStatus", nativeQuery = true)
	List<Userapplication> findByPendingApplications(String appStatus);
	
	Userapplication findByUserId(Long id);

	
//	@Query(value = "SELECT * FROM UserApplication As ua JOIN Drivinglicenses AS dl ON ua.user_id = dl.user_id WHERE ua.user_id = :userId", nativeQuery = true)
//	Userapplication findByUserId(int userId);
	
//	@Query(value = "SELECT ua.* ,dl.* FROM UserApplication  ua JOIN ua.Drivinglicenses dl ON ua.user_id = dl.user_id WHERE ua.user_id = :userId", nativeQuery = true)
//
//	Optional<Userapplication> findById(Long id);
//	

	Userapplication findByOfficialEmail(String officialEmail);
	
//	@Query(value = "SELECT * FROM UserApplication WHERE userName = :userName", nativeQuery = true)
	Userapplication findByUserName(String userName);



	Userapplication findFirstByOfficialEmail(String email);

	Userapplication findByPhoneNumber(String mobile);
}
