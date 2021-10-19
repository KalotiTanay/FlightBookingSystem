package com.flightService.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.flightService.model.Screening;
import com.flightService.model.Seat;
import com.flightService.repository.ScreeningRepository;

@Service
@Primary
public class ScreeningService {

	@Autowired
	private ScreeningRepository screeningRepository;
	
	//GET Methods
	
	public List<Screening> getAllScreenings() {
        return screeningRepository.findAll();
    }
	
	
	public List<Screening> getAllScreenings(LocalDate startDate, LocalDate endDate) {
        return screeningRepository.findAll().stream().filter(screening -> screening.getDate().isAfter(startDate) && screening.getDate().isBefore(endDate)).collect(Collectors.toList());
    }
	
	public Screening getScreeningById(Long screening_id) {
	       return screeningRepository.findById(screening_id).orElseThrow(RuntimeException :: new);
	}
	 
	public Screening pushScreening(Screening newScreening) {
        return screeningRepository.save(newScreening);
    }
	
	public List<Seat> getSeatsByScreeningId(Long screening_id) {
        Screening screening = getScreeningById(screening_id);
        if (screening.getIsFull()) {
            return new ArrayList<>();
        }
        return new ArrayList<>(screening.getFlight().getSeats());
    }
}
