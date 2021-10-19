package com.flightService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.flightService.model.Booking;
import com.flightService.service.BookingService;

@RestController
public class BookingController {

	@Autowired
	private BookingService bookingService;
	
	@GetMapping("/bookings/getAll")
	public List<Booking> getAllBookings(){
		return bookingService.getAllBookings();
	}
	
	@GetMapping("/bookings/get/{id}")
	public Booking getBookingById(@PathVariable Long id) {
		return bookingService.getBookingById(id);
	}
}
