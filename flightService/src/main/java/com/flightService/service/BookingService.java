package com.flightService.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.flightService.model.Booking;
import com.flightService.repository.BookingRepository;

@Service
@Primary
public class BookingService {

	@Autowired
	private BookingRepository bookingRepository;
	
	//GET Methods
	
	public List<Booking> getAllBookings(){
		return bookingRepository.findAll();
	}
	
	public Booking getBookingById(Long booking_id) {
		return bookingRepository.findById(booking_id).orElse(null);
	}
	
	//POST Methods
	
	public Booking saveBooking(Booking newBooking) {
		return bookingRepository.save(newBooking);
	}
	
	public List<Booking> saveAllBookings (List<Booking> newBookings) {
		return bookingRepository.saveAll(newBookings);
	}
	
	//DELETE Method
	
	public String deleteBooking(Long booking_id) {
		bookingRepository.deleteById(booking_id);
		return "Flight by id: "+booking_id+" is deleted form records !!";
	}
	
}
