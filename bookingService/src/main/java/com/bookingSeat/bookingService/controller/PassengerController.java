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

    @GetMapping("/boardingPassengers")
    public List<Passenger> getBoardingPassengers(@RequestParam(name = "flight_id") String flight_id){
        return this.passengerService.getPassengersByFlightId(flight_id);
    }

    @GetMapping("/boardingPassengers/user")
    public List<Passenger> getUserSpecificPassengers(@RequestParam(name = "user_id") String userid){
        return this.passengerService.getPassengersByUserName(userid);
    }

    @DeleteMapping("/boardingPassenger/deletePassenger")
    public String deleteBoardingPassenger(@RequestParam(name = "passenger_name") String name){
        passengerService.deletePassenger(name);
        return "Passenger with id: "+name+" is deleted successfully !!";
    }

}
