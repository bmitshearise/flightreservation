package org.bmit.flightreservation.services;

import org.bmit.flightreservation.dto.ReservationRequest;
import org.bmit.flightreservation.model.Reservation;

public interface ReservationService {
	
	public Reservation bookFlight(ReservationRequest request);

}
