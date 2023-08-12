package org.bmit.flightreservation.controller;

import java.util.Optional;

import org.bmit.flightreservation.dto.ReservationRequest;
import org.bmit.flightreservation.model.Flight;
import org.bmit.flightreservation.model.Reservation;
import org.bmit.flightreservation.repos.FlightRepository;
import org.bmit.flightreservation.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ReservationController {
	
	@Autowired
	private FlightRepository repo;
	
	@Autowired
	ReservationService reservationService;

	@RequestMapping("/showCompleteReservation")
	public String showCompleteReservation(@RequestParam("flightId") Long flightId, ModelMap modelMap) {
		Flight flight = repo.findById(flightId).get();
		modelMap.addAttribute("flight", flight);
		return "completereservation";
	}
	
	@RequestMapping(value="/completeReservation", method = RequestMethod.POST)
	public String completeReservation(ReservationRequest request, ModelMap modelMap) {
		Reservation reservation = reservationService.bookFlight(request);
		modelMap.addAttribute("msg", "Reservation created sucessfully and id is"+reservation.getId());
		return "reservationconfirmation";
	}
}
