package com.bookingSeat.bookingService.service;

import com.bookingSeat.bookingService.model.Passenger;
import com.bookingSeat.bookingService.repository.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class PassengerService {

    Random random = new Random();

    @Autowired
    private PassengerRepository passengerRepository;


    // Get Methods

    public List<Passenger> getAllPassengers(){
        return passengerRepository.findAll();
    }

    public List<Passenger> getPassengersByFlightId(Long flight_id){
        return passengerRepository.findAll().stream().filter(passengers -> passengers.getFlight_id().equals(flight_id))
                .collect(Collectors.toList());
    }

    public Passenger getPassengersByUserId(String user_id){
        return passengerRepository.findByUserId(user_id);
    }


    // Post Methods
    public Passenger savePassenger (Passenger passenger) {
        return passengerRepository.save(passenger);
    }

    public List<Passenger> savePassengers (List<Passenger> passengers) {
        return passengerRepository.saveAll(passengers);
    }

    // Delete passenger
    public String deletePassenger(Long ticket_id) {
        passengerRepository.deleteById(ticket_id);
        return "Flight by id: "+ticket_id+" is deleted form records !!";
    }


}
