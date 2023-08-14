package org.bmit.flightreservation.controller;

import org.bmit.flightreservation.dto.ReservationUpdateRequest;
import org.bmit.flightreservation.model.Reservation;
import org.bmit.flightreservation.repos.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class ReservationRestController {
	
	@Autowired
	private ReservationRepository reservationRepository;
	
	@RequestMapping("/reservation/{id}")
	public Reservation findReservation(@PathVariable("id") long id) {
		return reservationRepository.findById(id).get();
	}
	
	@RequestMapping("/reservation")
	public Reservation updateResrvation(@RequestBody ReservationUpdateRequest request) {
		Reservation reservation = reservationRepository.findById(request.getId()).get();
		reservation.setNumOfBags(request.getNumOfBags());
		reservation.setCheckIn(request.isCheckIn());
		return reservationRepository.save(reservation);
	}
}
