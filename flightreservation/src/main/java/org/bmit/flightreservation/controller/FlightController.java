package org.bmit.flightreservation.controller;


import java.util.Date;
import java.util.List;

import org.bmit.flightreservation.model.Flight;
import org.bmit.flightreservation.repos.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FlightController {
	
	@Autowired
	private FlightRepository flightRepository;
	
	@RequestMapping("/findflights")
	public String findFlights(@RequestParam("from") String from, @RequestParam("to") String to,@RequestParam("dateOfDeparture") String date, ModelMap modelMap)  {
		List<Flight> flight = flightRepository.findFlights(from, to, date);
		modelMap.addAttribute("flights", flight);
		return "displayflights";
	}
}
