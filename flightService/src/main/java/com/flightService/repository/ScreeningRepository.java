package com.flightService.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flightService.model.Screening;

public interface ScreeningRepository extends JpaRepository<Screening, Long> {

}
