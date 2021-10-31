package com.bookingSeat.bookingService.repository;

import com.bookingSeat.bookingService.model.Passenger;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface PassengerRepository extends MongoRepository<Passenger, String> {
    @Query("{user_id:?0}")
    List<Passenger> findByUserId(String user_id);
}
