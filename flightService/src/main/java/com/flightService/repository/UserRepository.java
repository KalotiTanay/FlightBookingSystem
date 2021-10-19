package com.flightService.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flightService.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	
	User getUserDetails();

}
