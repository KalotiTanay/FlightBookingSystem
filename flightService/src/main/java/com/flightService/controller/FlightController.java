package com.flightService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flightService.model.Flights;
import com.flightService.service.FlightService;

@RestController
@RequestMapping("/flightService")
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

	@GetMapping("/searchFlightById/{id}")
	public Flights findFlightById(@PathVariable int id) {
		return flightService.getFlightsByID(id);
	}
	
	@GetMapping("/searchFlightByCompany/{company}")
	public Flights findFlightsByCompany(@PathVariable String company) {
		return flightService.getFlightByCompany(company);
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
