package com.flightService.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flightService.model.Booking;

public interface BookingRepository extends JpaRepository<Booking, Long> {

}
