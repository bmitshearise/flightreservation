package org.bmit.flightreservation.repos;


import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.bmit.flightreservation.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface FlightRepository extends JpaRepository<Flight, Long> {
	
	@Modifying
	@Transactional
	@Query( value = "Select * from Flight f where f.DEPARTURE_CITY=:departureCity and f.ARRIVAL_CITY=:arrivalCity and f.DATE_OF_DEPARTURE=:dateOfDeparture",  nativeQuery = true)
	List<Flight> findFlights(@Param("departureCity") String from, @Param("arrivalCity") String to, @Param("dateOfDeparture") String dateOfDeparture);
	

}
