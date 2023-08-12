package org.bmit.flightreservation.services;

import org.bmit.flightreservation.dto.ReservationRequest;
import org.bmit.flightreservation.model.Flight;
import org.bmit.flightreservation.model.Passenger;
import org.bmit.flightreservation.model.Reservation;
import org.bmit.flightreservation.repos.FlightRepository;
import org.bmit.flightreservation.repos.PassengerRepository;
import org.bmit.flightreservation.repos.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationServiceImpl implements ReservationService {
	
	@Autowired
	FlightRepository flightRepository;
	
	@Autowired
	PassengerRepository passengerRepository;
	
	@Autowired
	ReservationRepository reservationRepository;

	@Override
	public Reservation bookFlight(ReservationRequest request) {
		//Make Payment
		Long flight = request.getFlightId();
		Flight flight2 = flightRepository.findById(flight).get();
		Passenger passenger = new Passenger();
		passenger.setFirstName(request.getPassengerFirstName());
		passenger.setLastName(request.getPassengerLastName());
		passenger.setPhone(request.getPassengerPhone());
		passenger.setEmail(request.getPassengerEmail());
		Passenger savedPassenger = passengerRepository.save(passenger);
		Reservation reservation = new Reservation();
		reservation.setFlight(flight2);
		reservation.setPassenger(savedPassenger);
		reservation.setPassenger(passenger);
		Reservation savedReservation = reservationRepository.save(reservation);
		return savedReservation;
	}

}
