package com.flightService.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flightService.model.Seat;

public interface SeatRepository extends JpaRepository<Seat, Long> {

}
