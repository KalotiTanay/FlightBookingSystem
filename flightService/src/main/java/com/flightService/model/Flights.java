package com.flightService.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.boot.context.properties.bind.Name;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "Flights_Registry")
public class Flights {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String flightName;
	@Column(name="departure")
	private String from_loc;
	@Column(name="landing")
	private String to_loc;
	private String company;
	
	private int capacity;
	
	@OneToMany(mappedBy = "Flights_Registry", cascade = CascadeType.ALL)
	@JsonBackReference
	private Set<Seat> seats;
	
	@OneToMany(mappedBy = "Flights_Registry", cascade = CascadeType.ALL)
	@JsonBackReference
	private Set<Screening> screening;
}
