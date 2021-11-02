package com.flightService.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.flightService.model.Flights;
import com.flightService.service.FlightService;

@RestController
@RequestMapping("/flightService")
@CrossOrigin(origins = "*", maxAge = 3600)
public class FlightController {
	
	@Autowired
	private FlightService flightService;
	
	
	// POST methods
	
	@PostMapping("/addFlight")
	public Flights addFlight(@RequestBody Flights flight) {
		return flightService.saveFlight(flight);
	}
	
	@PostMapping("/addFlights")
	public List<Flights> addFlights(@RequestBody List<Flights> flights){
		return flightService.saveFlights(flights);
	}

	//GET Methods
	
	@GetMapping("/searchFlights")
	public List<Flights> findAllFlights(){
		return flightService.getFlights();
	}

	@GetMapping("/departures")
	public ArrayList<String> getDepartures() { return flightService.getSourceDest(); }

	@GetMapping("/landings")
	public ArrayList<String> getLandings() { return flightService.getFinalDest(); }

	@GetMapping("/searchFlightById/{id}")
	public Flights findFlightById(@PathVariable int id) {
		return flightService.getFlightsByID(id);
	}
	
	@GetMapping("/searchFlightByCompany")
	public List<Flights> findFlightsByCompany(@RequestParam (name = "company") String company) {
		return flightService.getFlightByCompany(company);
	}

	@GetMapping("/flightId/{loc1}/{loc2}")
	public Long getIdByLoc(@PathVariable String loc1, @PathVariable String loc2) {
		return flightService.getFlightID(loc1, loc2);
	}
	
	@PutMapping("/updateFlight")
	public Flights updateFlight(@RequestBody Flights flight) {
		return flightService.updateFlight(flight);
	}
	
	@DeleteMapping("/deleteFlight/{id}")
	public String deleteFlight(@PathVariable int id) {
		return flightService.deleteFlight(id);
	}
}
