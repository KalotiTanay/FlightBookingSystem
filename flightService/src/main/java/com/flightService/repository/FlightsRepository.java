package com.flightService.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flightService.model.Flights;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;
import java.util.List;

public interface FlightsRepository extends JpaRepository<Flights, Long> {

	Flights findByCompany(String company);

	@Query("FROM Flights WHERE company = ?1")
	List<Flights> findFlightsByCompany(String company);

	@Query(value="SELECT departure FROM flights_registry", nativeQuery = true)
	ArrayList<String> getSourceLoc();

	@Query(value="SELECT landing FROM flights_registry", nativeQuery = true)
	ArrayList<String> getDestLoc();
}
