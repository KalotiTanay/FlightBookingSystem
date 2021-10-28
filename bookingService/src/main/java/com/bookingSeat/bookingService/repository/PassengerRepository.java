package com.bookingSeat.bookingService.repository;

import com.bookingSeat.bookingService.model.Passenger;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PassengerRepository extends MongoRepository<Passenger, Long> {
}
