package com.cognizant.ridesharingplatform.ridemanagement.servicesimpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.ridesharingplatform.ridemanagement.dtos.DistancesDto;
import com.cognizant.ridesharingplatform.ridemanagement.dtos.FareParametersDto;
import com.cognizant.ridesharingplatform.ridemanagement.dtos.RideSchedulesDto;
import com.cognizant.ridesharingplatform.ridemanagement.dtos.SearchCriteriaDto;
import com.cognizant.ridesharingplatform.ridemanagement.entities.Bookings;
import com.cognizant.ridesharingplatform.ridemanagement.entities.Distances;
import com.cognizant.ridesharingplatform.ridemanagement.entities.RideSchedules;
import com.cognizant.ridesharingplatform.ridemanagement.entities.Vehicles;
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
import com.cognizant.ridesharingplatform.ridemanagement.repos.VehiclesRepository;
import com.cognizant.ridesharingplatform.ridemanagement.services.RideService;
@Service
public class RideServiceImpl implements RideService{
	
	@Autowired
	DistancesRepository distancesRepository;
	
	@Autowired
	BookingsRepository bookingsRepository;
	
	@Autowired
	RideSchedulesRepository rideSchedulesRepository;
	
	@Autowired
	VehiclesRepository vehiclesRepository;
	
	
	public List<DistancesDto> getAllDistances(){
		List<Distances> allDistances= distancesRepository.findAll();
		return allDistances.stream().map(DistancesMapper::distancesToDistancesDto).collect(Collectors.toList());
		
	}
	
	@Override
	public int calculateFare(FareParametersDto fareParametersDto) throws NoRideFoundException {
		// TODO Auto-generated method stub
		String registrationNo = fareParametersDto.getRegistrationNo();
		RideSchedules rideSchedules=rideSchedulesRepository.findByVehicleRegistrationNo(registrationNo);
				if(rideSchedules==null) {
					throw new NoRideFoundException();
				}
		Vehicles vehicle = vehiclesRepository.findByRegistrationNo(registrationNo);
				if(vehicle==null) {
					throw new NoRideFoundException();
				}
				String ridefrom=rideSchedules.getRideFrom();
				String rideto=rideSchedules.getRideTo();
		Distances distance=distancesRepository.findDistanceInKmsBydistancefromAndDistanceTo(ridefrom,rideto);
		int fareperkm = vehicle.getFarePerKm();
		int dis=distance.getDistanceInKms();
		return fareperkm*dis;
	}
	
	@Override
	public RideSchedulesDto createRide(RideSchedulesDto rideSchedulesDto)
			throws VehicleNotApprovedException, MaximumCapacityExceededException,NoVehicleFoundException {
		// TODO Auto-generated method stub
		Vehicles vehicles=vehiclesRepository.findByRegistrationNo(rideSchedulesDto.getVehicleRegistrationNo());
		if(vehicles==null) {
			throw new NoVehicleFoundException("No vehicle found with the given regitration number");
		}
		else if(!vehicles.getInspectionStatus().equalsIgnoreCase("Approved")){
			throw new VehicleNotApprovedException();
	
		}
		else if(rideSchedulesDto.getNoOfSeatsAvailable()>vehicles.getMaxSeats()) {
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

}
