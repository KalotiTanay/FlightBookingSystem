package com.flightService.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flightService.model.Flights;
import com.flightService.repository.FlightsRepository;

@Service
public class FlightService {

	@Autowired
	private FlightsRepository flightsRepository;
	
	// POST Methods
	
	public Flights saveFlight (Flights flight) {
		return flightsRepository.save(flight);
	}
	
	public List<Flights> saveFlights (List<Flights> flights) {
		return flightsRepository.saveAll(flights);
	}
	
	
	// GET Methods
	
	public List<Flights> getFlights() {
		return flightsRepository.findAll();
	}
	
	public Flights getFlightsByID(long id) {
		return flightsRepository.findById(id).orElse(null);
	}
	
	public List<Flights> getFlightByCompany(String company) {
		return flightsRepository.findFlightsByCompany(company);
	}

	public ArrayList<String> getSourceDest() {
		return flightsRepository.getSourceLoc();
	}

	public ArrayList<String> getFinalDest() {
		return flightsRepository.getDestLoc();
	}

	public Long getFlightID(String loc1, String loc2) {return flightsRepository.findByLocations(loc1, loc2);}
	
	// Delete Method
	
	public String deleteFlight(long id) {
		flightsRepository.deleteById(id);
		return "Flight by id: "+id+" is deleted form records !!";
	}
	
	// Update Method
	
	public Flights updateFlight(Flights flight) {
		Flights existingFlight = flightsRepository.findById(flight.getId()).orElse(null);
		existingFlight.setCompany(flight.getCompany());
		existingFlight.setFlightName(flight.getFlightName());
		existingFlight.setSrc_loc(flight.getSrc_loc());
		existingFlight.setDest_loc(flight.getDest_loc());
		
		return flightsRepository.save(existingFlight);
	}

}
