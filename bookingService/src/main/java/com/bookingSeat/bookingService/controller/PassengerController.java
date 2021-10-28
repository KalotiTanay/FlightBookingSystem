package com.bookingSeat.bookingService.controller;


import com.bookingSeat.bookingService.model.Passenger;
import com.bookingSeat.bookingService.service.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/passenger")
public class PassengerController {

    @Autowired
    private PassengerService passengerService;

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/addPassenger")
    public Passenger addPassenger(@RequestBody Passenger passenger) {
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

    @GetMapping("/boardingPassengers/{flight_id}")
    public List<Passenger> getBoardingPassengers(@PathVariable("flight_id") Long flight_id){
        List flights = this.restTemplate.getForObject("http://localhost:8081/searchFlightById/"+flight_id,List.class);
        return this.passengerService.getPassengersByFlightId(flight_id);
    }

    @GetMapping("/boardingPassengers/user/{username}")
    public List<Passenger> getUserSpecificPassengers(@PathVariable("username") String username){
        return this.passengerService.getPassengersByUserName(username);
    }

    @DeleteMapping("/boardingPassenger/deletePassenger")
    public String deleteBoardingPassenger(@RequestParam(name = "passenger_id") Long id){
        passengerService.deletePassenger(id);
        return "Passenger with id: "+id+" is deleted successfully !!";
    }

}
