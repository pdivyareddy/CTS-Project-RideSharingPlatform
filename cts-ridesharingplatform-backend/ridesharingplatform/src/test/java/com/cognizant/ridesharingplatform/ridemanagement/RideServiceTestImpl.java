package com.cognizant.ridesharingplatform.ridemanagement;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.cognizant.ridesharingplatform.ridemanagement.entities.Bookings;
import com.cognizant.ridesharingplatform.ridemanagement.dtos.DistancesDto;
import com.cognizant.ridesharingplatform.ridemanagement.dtos.FareParametersDto;
import com.cognizant.ridesharingplatform.ridemanagement.dtos.RideSchedulesDto;
import com.cognizant.ridesharingplatform.ridemanagement.dtos.SearchCriteriaDto;
import com.cognizant.ridesharingplatform.ridemanagement.entities.Distances;
import com.cognizant.ridesharingplatform.ridemanagement.entities.RideSchedules;
import com.cognizant.ridesharingplatform.vehiclemanagement.model.*;
import com.cognizant.ridesharingplatform.ridemanagement.exceptions.*;
import com.cognizant.ridesharingplatform.ridemanagement.repos.BookingsRepository;
import com.cognizant.ridesharingplatform.ridemanagement.repos.DistancesRepository;
import com.cognizant.ridesharingplatform.ridemanagement.repos.RideSchedulesRepository;
import com.cognizant.ridesharingplatform.vehiclemanagement.repository.*;

import com.cognizant.ridesharingplatform.ridemanagement.servicesimpl.RideServiceImpl;

class RideServiceTestImpl {
    @Mock
    private DistancesRepository distancesRepository;
    
    @Mock
    private BookingsRepository bookingsRepository;
    
    @Mock
    private RideSchedulesRepository rideSchedulesRepository;
    
    @Mock
    private VehicleRepository vehicleRepository;
    
    @InjectMocks
    private RideServiceImpl rideService;
    
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }
    
    @Test
    void testGetAllDistances() {
        // Arrange
        List<Distances> distancesList = new ArrayList<>();
        distancesList.add(new Distances(1001,"City A", "City B", 100));
        distancesList.add(new Distances(1002,"City B", "City C", 200));
        
        when(distancesRepository.findAll()).thenReturn(distancesList);
        
        // Act
        List<DistancesDto> result = rideService.getAllDistances();
        
        // Assert
        assertEquals(2, result.size());
        assertEquals("City A", result.get(0).getDistanceFrom());
        assertEquals("City B", result.get(0).getDistanceTo());
        assertEquals(100, result.get(0).getDistanceInKms());
        assertEquals("City B", result.get(1).getDistanceFrom());
        assertEquals("City C", result.get(1).getDistanceTo());
        assertEquals(200, result.get(1).getDistanceInKms());
        
        verify(distancesRepository).findAll();
    }

   /*
  
    
    @Test
    void testCalculateFare_RideSchedulesFound() throws NoRideFoundException {
        // Arrange
        FareParametersDto fareParametersDto = new FareParametersDto("ABC123");
        RideSchedules rideSchedules = new RideSchedules();
        rideSchedules.setRideFrom("City A");
        rideSchedules.setRideTo("City B");

        VehicleTypes vehicletypes = new VehicleTypes();
        vehicletypes.setFarePerKM(10);

        Distances distance = new Distances(1001,"City A", "City B", 100);

        when(rideSchedulesRepository.findByVehicleRegistrationNo("ABC123")).thenReturn(rideSchedules);
        when(vehicleRepository.findByRegistrationNo("ABC123")).thenReturn(vehicletypes);
        when(distancesRepository.findDistanceInKmsBydistancefromAndDistanceTo("City A", "City B")).thenReturn(distance);

        // Act
        int result = rideService.calculateFare(fareParametersDto);

        // Assert
        assertEquals(1000, result);

        verify(rideSchedulesRepository).findByVehicleRegistrationNo("ABC123");
        verify(vehicleRepository).findByRegistrationNo("ABC123");
        verify(distancesRepository).findDistanceInKmsBydistancefromAndDistanceTo("City A", "City B");
    }
    */

    @Test
    void testCalculateFare_NoRideFoundException() {
        // Arrange
        FareParametersDto fareParametersDto = new FareParametersDto("ABC123");
        
        when(rideSchedulesRepository.findByVehicleRegistrationNo("ABC123")).thenReturn(null);
        
        // Act & Assert
        assertThrows(NoRideFoundException.class, () -> rideService.calculateFare(fareParametersDto));
        
        verify(rideSchedulesRepository).findByVehicleRegistrationNo("ABC123");
        verifyNoInteractions(vehicleRepository);
        verifyNoInteractions(distancesRepository);
    }

    
    // Add more test methods for other methods in the RideServiceImpl class
    // ...
    
/*
    @Test
    void testCreateRide_ValidRide() throws VehicleNotApprovedException, MaximumCapacityExceededException, NoVehicleFoundException {
        // Arrange
        RideSchedulesDto rideSchedulesDto = new RideSchedulesDto();
        rideSchedulesDto.setVehicleRegistrationNo("ABC123");
        rideSchedulesDto.setNoOfSeatsAvailable(2);
        
        VehicleTypes vehicletypes = new VehicleTypes();
        Vehicle vehicle=new Vehicle();
        vehicle.setRegistrationNo("ABC123");
        vehicle.setInspectionStatus("Approved");
        vehicletypes.setMaxPassengersAllowed(4);
        
        when(vehicleRepository.findByRegistrationNo("ABC123")).thenReturn(vehicle);
        when(rideSchedulesRepository.save(any(RideSchedules.class))).thenAnswer(invocation -> invocation.getArgument(0));
        
        // Act
        RideSchedulesDto result = rideService.createRide(rideSchedulesDto);
        
        // Assert
        assertEquals("ABC123", result.getVehicleRegistrationNo());
        assertEquals(2, result.getNoOfSeatsAvailable());
        
        verify(vehicleRepository).findByRegistrationNo("ABC123");
        verify(rideSchedulesRepository).save(any(RideSchedules.class));
    }
   */


    @Test
    void testCreateRide_NoVehicleFoundException() throws VehicleNotApprovedException, MaximumCapacityExceededException, NoVehicleFoundException {
        // Arrange
        RideSchedulesDto rideSchedulesDto = new RideSchedulesDto();
        rideSchedulesDto.setVehicleRegistrationNo("ABC123");
        
        when(vehicleRepository.findByRegistrationNo("ABC123")).thenReturn(null);
        
        // Act & Assert
        assertThrows(NoVehicleFoundException.class, () -> rideService.createRide(rideSchedulesDto));
        
        verify(vehicleRepository).findByRegistrationNo("ABC123");
        verifyNoInteractions(rideSchedulesRepository);
    }
    


    @Test
    void testCreateRide_VehicleNotApprovedException() throws VehicleNotApprovedException, MaximumCapacityExceededException, NoVehicleFoundException {
        // Arrange
        RideSchedulesDto rideSchedulesDto = new RideSchedulesDto();
        rideSchedulesDto.setVehicleRegistrationNo("ABC123");
        
        Vehicle vehicle = new Vehicle();
        vehicle.setRegistrationNo("ABC123");
        vehicle.setInspectionStatus("Pending");
        
        when(vehicleRepository.findByRegistrationNo("ABC123")).thenReturn(vehicle);
        
        // Act & Assert
        assertThrows(VehicleNotApprovedException.class, () -> rideService.createRide(rideSchedulesDto));
        
        verify(vehicleRepository).findByRegistrationNo("ABC123");
        verifyNoInteractions(rideSchedulesRepository);
    }

/*
    @Test
    void testCreateRide_MaximumCapacityExceededException() throws VehicleNotApprovedException, MaximumCapacityExceededException, NoVehicleFoundException {
        // Arrange
        RideSchedulesDto rideSchedulesDto = new RideSchedulesDto();
        rideSchedulesDto.setVehicleRegistrationNo("ABC123");
        rideSchedulesDto.setNoOfSeatsAvailable(4);
        
        Vehicle vehicle = new Vehicle();
        VehicleTypes vehicletypes = new VehicleTypes();
        vehicle.setRegistrationNo("ABC123");
        vehicle.setInspectionStatus("Approved");
        vehicletypes.setMaxPassengersAllowed(4);;
        
        when(vehicleRepository.findByRegistrationNo("ABC123")).thenReturn(vehicle);
        
        // Act & Assert
        assertThrows(MaximumCapacityExceededException.class, () -> rideService.createRide(rideSchedulesDto));
        
        verify(vehicleRepository).findByRegistrationNo("ABC123");
        verifyNoInteractions(rideSchedulesRepository);
    }
    */

    @Test
    void testSearchRideSchedule_ValidSearchCriteria() throws BadSearchCriteriaException, NoRideFoundException {
        // Arrange
        SearchCriteriaDto searchCriteria = new SearchCriteriaDto();
        searchCriteria.setDistance_from("City A");
        searchCriteria.setDistance_to("City B");
        searchCriteria.setMin_price(100);
        searchCriteria.setMax_price(200);
        searchCriteria.setAvailable_seats(2);
        
        RideSchedules ride1 = new RideSchedules(1001,"City A","City B",null, null, 150, "ABC123", 150, 2);
        RideSchedules ride2 = new RideSchedules(1002, "City A", "City B",null, null, 180, "DEF456", 180, 2);
        
        List<RideSchedules> rides = Arrays.asList(ride1, ride2);
        
        when(rideSchedulesRepository.findRideByRideFromAndRideToAndRideFareLessThanEqualAndRideFareGreaterThanEqualAndNoOfSeatsAvailableGreaterThanEqual(
                "City A", "City B", 200, 100, 2)).thenReturn(rides);
        
        // Act
        List<RideSchedulesDto> result = rideService.searchRideSchedule(searchCriteria);
        
        // Assert
        assertEquals(2, result.size());
        assertEquals("ABC123", result.get(0).getVehicleRegistrationNo());
        assertEquals("DEF456", result.get(1).getVehicleRegistrationNo());
        
        verify(rideSchedulesRepository).findRideByRideFromAndRideToAndRideFareLessThanEqualAndRideFareGreaterThanEqualAndNoOfSeatsAvailableGreaterThanEqual(
                "City A", "City B", 200, 100, 2);
    }
    
    @Test
    void testCreateBooking_ValidBooking() throws BookingAlreadyExistException, MaxSeatsPerRideExceededException {
        // Arrange
        Bookings bookings = new Bookings();
        bookings.setBookingId(1);
        bookings.setNoOfSeats(2);
        
        when(bookingsRepository.existsById(1)).thenReturn(false);
        when(bookingsRepository.save(any(Bookings.class))).thenAnswer(invocation -> invocation.getArgument(0));
        
        // Act
        Bookings result = rideService.createBooking(bookings);
        
        // Assert
        assertEquals(1, result.getBookingId());
        assertEquals(2, result.getNoOfSeats());
        
        verify(bookingsRepository).existsById(1);
        verify(bookingsRepository).save(any(Bookings.class));
    }



}
