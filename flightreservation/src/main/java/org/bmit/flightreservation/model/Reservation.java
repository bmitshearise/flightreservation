package org.bmit.flightreservation.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "RESERVATION")
public class Reservation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;

	@Column(name = "CHECKD_IN")
	private boolean checkIn;

	@Column(name = "NUMBER_OF_BAGS")
	private Long numOfBags;

	@OneToOne
	private Passenger passenger;

	@OneToOne
	private Flight flight;

	@Column(name = "CREATED")
	private Timestamp created;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public boolean isCheckIn() {
		return checkIn;
	}

	public void setCheckIn(boolean checkIn) {
		this.checkIn = checkIn;
	}

	public Long getNumOfBags() {
		return numOfBags;
	}

	public void setNumOfBags(Long numOfBags) {
		this.numOfBags = numOfBags;
	}

	public Passenger getPassenger() {
		return passenger;
	}

	public void setPassenger(Passenger passenger) {
		this.passenger = passenger;
	}

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	public Timestamp getCreated() {
		return created;
	}

	public void setCreated(Timestamp created) {
		this.created = created;
	}

	@Override
	public String toString() {
		return "Reservation [id=" + id + ", checkIn=" + checkIn + ", numOfBags=" + numOfBags + ", passenger="
				+ passenger + ", flight=" + flight + ", created=" + created + "]";
	}

}
