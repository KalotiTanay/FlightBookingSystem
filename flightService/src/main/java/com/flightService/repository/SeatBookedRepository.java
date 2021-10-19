package com.flightService.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flightService.model.SeatBooked;

public interface SeatBookedRepository extends JpaRepository<SeatBooked, Long> {

}
