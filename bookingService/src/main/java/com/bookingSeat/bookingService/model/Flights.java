package com.bookingSeat.bookingService.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


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
	private String src_loc;
	@Column(name="landing")
	private String dest_loc;
	private String company;
	
	private int capacity;
}
