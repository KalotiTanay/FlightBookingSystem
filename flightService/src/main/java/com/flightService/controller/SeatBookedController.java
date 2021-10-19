package com.flightService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.flightService.model.SeatBooked;
import com.flightService.service.SeatBookedService;

@RestController
public class SeatBookedController {

	@Autowired
	private SeatBookedService seatBookedService;
	
	@GetMapping("/seatbooked")
    public List<SeatBooked> getAllSeatBooked() {
        return seatBookedService.getAllSeatBooked();
    }
	
	@DeleteMapping("/cancelSeatBooking/{booking_id}")
	public String cancelSeatBooking(@PathVariable Long id) {
		return seatBookedService.deleteSeatBookedById(id);
	}
	
}
