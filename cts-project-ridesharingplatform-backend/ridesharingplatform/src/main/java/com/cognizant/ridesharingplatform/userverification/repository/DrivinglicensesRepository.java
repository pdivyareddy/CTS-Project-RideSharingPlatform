package com.cognizant.ridesharingplatform.userverification.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cognizant.ridesharingplatform.userverification.dto.DrivinglicenseDto;
import com.cognizant.ridesharingplatform.userverification.entity.Drivinglicenses;

@Repository
public interface DrivinglicensesRepository extends JpaRepository<Drivinglicenses, Long> {
	
	
	@Query(value = "SELECT * FROM Drivinglicenses  WHERE  user_id= :userId", nativeQuery = true)

	Drivinglicenses getuserById(Long userId);

//	Drivinglicenses saveAll(DrivinglicenseDto userinfo);
	
	

}
