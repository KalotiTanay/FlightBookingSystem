package com.flightService.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flightService.model.Flights;

public interface FlightsRepository extends JpaRepository<Flights, Integer> {

	Flights findByCompany(String company);
	
	
}
