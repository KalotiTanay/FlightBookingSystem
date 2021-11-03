package com.bookingSeat.bookingService.controller;


import com.bookingSeat.bookingService.model.Passenger;
import com.bookingSeat.bookingService.service.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/passenger")
@CrossOrigin(origins = "*", maxAge = 3600)
public class PassengerController {

    @Autowired
    private PassengerService passengerService;

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/addPassenger")
    public Passenger addPassenger(@RequestBody Passenger passenger) {

        Random random = new Random();
        passenger.setTicket_id(random.nextLong(9999));

        Long flightID = this.restTemplate.getForObject("http://localhost:8300/flightService/flightId/"+passenger.getSource_loc()+"/"+passenger.getDest_loc(), Long.class);

        passenger.setFlight_id(flightID);

        return passengerService.savePassenger(passenger);
    }

    @PostMapping("/addPassenngers")
    public List<Passenger> addPassengers(@RequestBody List<Passenger> passengers){
        return passengerService.savePassengers(passengers);
    }

    @GetMapping("/findAllPassengers")
    public List<Passenger> getAllPassengers(){
        return this.passengerService.getAllPassengers();
    }

    @GetMapping("/boardingPassengers")
    public List<Passenger> getBoardingPassengers(@RequestParam(name = "flight_id") Long flight_id){
        return this.passengerService.getPassengersByFlightId(flight_id);
    }

    @GetMapping("/boardingPassengers/user/{user_id}")
    public List<Passenger> getUserSpecificPassengers(@PathVariable String user_id){
        return this.passengerService.getPassengersByUserId(user_id);
    }

    @DeleteMapping("/boardingPassenger/deletePassenger/{ticket_id}")
    public String deleteBoardingPassenger(@PathVariable Long ticket_id){
        return passengerService.deletePassenger(ticket_id);
    }

}
