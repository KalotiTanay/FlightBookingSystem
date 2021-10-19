package com.flightService.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.flightService.model.Seat;
import com.flightService.repository.SeatRepository;

@Service
@Primary
public class SeatService {

	@Autowired
	private SeatRepository seatRepository;

	 public List<Seat> getAllSeats() {
	        return seatRepository.findAll();
	    }
	
	 public Seat getSeatById(Long seat_id) {
	        return seatRepository.findById(seat_id).orElse(null);
	    }
	 
	 public Seat pushSeat(Seat newSeat) {
	        return seatRepository.save(newSeat);
	    }
	 
	 public Seat updateSeat(Seat updatedSeat, Long seat_id) {
	        if(seatRepository.getById(seat_id) != null) {
	        	return seatRepository.save(updatedSeat);
	        }	        
	        return null;
	    }
	 
	 public String deleteSeatById(Long seat_id) {
		 	seatRepository.deleteById(seat_id);
		 	return "Seat with id: "+seat_id+" is deleted form records !!";
	    }
}
