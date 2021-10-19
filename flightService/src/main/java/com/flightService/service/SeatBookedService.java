package com.flightService.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.flightService.model.SeatBooked;
import com.flightService.repository.SeatBookedRepository;

@Service
@Primary
public class SeatBookedService {

	@Autowired
	private SeatBookedRepository seatBookedRepository;
	
	 public List<SeatBooked> getAllSeatBooked() {
	        return seatBookedRepository.findAll();
	 }

	 public SeatBooked getSeatBookedById(Long seat_booked_id) {
	        return seatBookedRepository.findById(seat_booked_id).orElse(null);
	 }
	 
	 public SeatBooked pushSeatBooked(SeatBooked newSeatBooked) {
	        return seatBookedRepository.save(newSeatBooked);
	 }
	 
	 public String deleteSeatBookedById(Long seat_booked_id) {
		 	seatBookedRepository.deleteById(seat_booked_id);
		 	return "Seat Booking: "+seat_booked_id+" is deleted form records !!";
	 }
}
