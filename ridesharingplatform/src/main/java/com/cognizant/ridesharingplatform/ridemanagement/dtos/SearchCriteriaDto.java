package com.cognizant.ridesharingplatform.ridemanagement.dtos;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchCriteriaDto {
	private String distance_from;
	private String distance_to;
	private int max_price;
	private int min_price;
	private int available_seats;

}
