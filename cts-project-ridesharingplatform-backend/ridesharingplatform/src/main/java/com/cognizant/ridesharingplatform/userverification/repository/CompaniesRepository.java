package com.cognizant.ridesharingplatform.userverification.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cognizant.ridesharingplatform.userverification.entity.Companies;


@Repository
public interface CompaniesRepository extends JpaRepository<Companies, Long> {

	@Query(value = "SELECT * FROM Companies WHERE building_name = :name", nativeQuery = true)
	List<Companies> findByBuildingName(String name);

}
