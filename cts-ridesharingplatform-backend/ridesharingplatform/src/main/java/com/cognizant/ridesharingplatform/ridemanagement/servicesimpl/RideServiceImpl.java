package com.cognizant.ridesharingplatform.ridemanagement.servicesimpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.ridesharingplatform.ridemanagement.dtos.DistancesDto;
import com.cognizant.ridesharingplatform.ridemanagement.dtos.RideSchedulesDto;
import com.cognizant.ridesharingplatform.ridemanagement.dtos.SearchCriteriaDto;
import com.cognizant.ridesharingplatform.ridemanagement.entities.Bookings;
import com.cognizant.ridesharingplatform.ridemanagement.entities.Distances;
import com.cognizant.ridesharingplatform.ridemanagement.entities.RideSchedules;
import com.cognizant.ridesharingplatform.ridemanagement.exceptions.BadSearchCriteriaException;
import com.cognizant.ridesharingplatform.ridemanagement.exceptions.BookingAlreadyExistException;
import com.cognizant.ridesharingplatform.ridemanagement.exceptions.MaxSeatsPerRideExceededException;
import com.cognizant.ridesharingplatform.ridemanagement.exceptions.MaximumCapacityExceededException;
import com.cognizant.ridesharingplatform.ridemanagement.exceptions.NoRideFoundException;
import com.cognizant.ridesharingplatform.ridemanagement.exceptions.NoVehicleFoundException;
import com.cognizant.ridesharingplatform.ridemanagement.exceptions.VehicleNotApprovedException;
import com.cognizant.ridesharingplatform.ridemanagement.mapper.DistancesMapper;
import com.cognizant.ridesharingplatform.ridemanagement.mapper.RideSchedulesMapper;
import com.cognizant.ridesharingplatform.ridemanagement.repos.BookingsRepository;
import com.cognizant.ridesharingplatform.ridemanagement.repos.DistancesRepository;
import com.cognizant.ridesharingplatform.ridemanagement.repos.RideSchedulesRepository;
import com.cognizant.ridesharingplatform.ridemanagement.services.RideService;
import com.cognizant.ridesharingplatform.vehiclemanagement.model.Vehicle;
import com.cognizant.ridesharingplatform.vehiclemanagement.repository.VehicleRepository;
@Service
public class RideServiceImpl implements RideService{
	
	@Autowired
	DistancesRepository distancesRepository;
	
	@Autowired
	BookingsRepository bookingsRepository;
	
	@Autowired
	RideSchedulesRepository rideSchedulesRepository;
	
	@Autowired
	VehicleRepository vehiclesRepository;
	
	
	public List<DistancesDto> getAllDistances(){
		List<Distances> allDistances= distancesRepository.findAll();
		return allDistances.stream().map(DistancesMapper::distancesToDistancesDto).collect(Collectors.toList());
		
	}
	
	@Override
	public int calculateFare(String vehicleRegistrationNo,String rFrom,String rTo) {
		// TODO Auto-generated method stub
		
		//RideSchedules rideSchedules=rideSchedulesRepository.findByVehicleRegistrationNo(vehicleRegistrationNo);
		Vehicle vehicle = vehiclesRepository.findByRegistrationNo(vehicleRegistrationNo);
				//String ridefrom=rideSchedules.getRideFrom();
				//String rideto=rideSchedules.getRideTo();
		Distances distance=distancesRepository.findDistanceInKmsBydistancefromAndDistanceTo(rFrom,rTo);
		int fareperkm = vehicle.getVehicleTypes().getFarePerKM();
		int dis=distance.getDistanceInKms();
		return fareperkm*dis;
	}
	
	@Override
	public RideSchedulesDto createRide(RideSchedulesDto rideSchedulesDto)
			throws VehicleNotApprovedException, MaximumCapacityExceededException,NoVehicleFoundException {
		// TODO Auto-generated method stub
		Vehicle vehicles=vehiclesRepository.findByRegistrationNo(rideSchedulesDto.getVehicleRegistrationNo());
		if(vehicles==null) {
			throw new NoVehicleFoundException("No vehicle found with the given regitration number");
		}
		else if(!vehicles.getInspectionStatus().equalsIgnoreCase("Approved")){
			throw new VehicleNotApprovedException();
	
		}
		else if(rideSchedulesDto.getNoOfSeatsAvailable()>vehicles.getVehicleTypes().getMaxPassengersAllowed()) {
			throw new MaximumCapacityExceededException();
		}
		
		else {
		RideSchedules rideSchedules=RideSchedulesMapper.rideschedulesDtoToRideSchedule(rideSchedulesDto);
		RideSchedules saveRide= rideSchedulesRepository.save(rideSchedules);
		
		RideSchedulesDto saveRideDto=RideSchedulesMapper.rideschedulesToRideScheduleDto(saveRide);
		return saveRideDto;
		}
		
	}
	
	@Override
	public List<RideSchedulesDto> searchRideSchedule(SearchCriteriaDto searchCriteria)
			throws BadSearchCriteriaException, NoRideFoundException {
		if(searchCriteria.getDistance_from().isEmpty() ||searchCriteria.getDistance_to().isEmpty()||
				searchCriteria.getMin_price()==0||searchCriteria.getMax_price()==0||searchCriteria.getAvailable_seats()==0) {
			throw new BadSearchCriteriaException();
		}
	
		List<RideSchedules> rides=rideSchedulesRepository.findRideByRideFromAndRideToAndRideFareLessThanEqualAndRideFareGreaterThanEqualAndNoOfSeatsAvailableGreaterThanEqual(
				searchCriteria.getDistance_from(),
				searchCriteria.getDistance_to(),
				searchCriteria.getMax_price(),
				searchCriteria.getMin_price(),
				searchCriteria.getAvailable_seats()
				);
		//System.out.println(rides);
		return rides.stream().map(RideSchedulesMapper::rideschedulesToRideScheduleDto).collect(Collectors.toList());
	}
	
	@Override
	public Bookings createBooking(Bookings bookings)
			throws BookingAlreadyExistException, MaxSeatsPerRideExceededException {
		// TODO Auto-generated method stub
		Bookings boo;
		int seats = bookings.getNoOfSeats();
		if (bookingsRepository.existsById(bookings.getBookingId())) {
			throw new BookingAlreadyExistException();
		}
		else {
			if(seats <= 2) {
				boo = bookingsRepository.save(bookings);
			} 
			else {
				throw new MaxSeatsPerRideExceededException();
			}
		}
		return boo;

	}
	
}
	
	
	
/*	
	@Override
	public List<Bookings> searchBookingByRiderUserId(int riderUserId) throws BookingNotFoundException {
		List<Bookings> bookings=bookingsRepository.findByRiderUserId(riderUserId);
		if(bookings.isEmpty()) {
			throw new BookingNotFoundException();
		}
		
		return bookings;
	}
	
	*/
	
/*
	
	public List<RideSchedules> getAllRideSchedules() {
		return (List<RideSchedules>) rideSchedulesRepository.findAll();
	}
*/
	/*
	 @Override
	public List<Vehicles> getAllVehicles() {

		return (List<Vehicles>) vehiclesRepository.findAll();
	}
	 */

