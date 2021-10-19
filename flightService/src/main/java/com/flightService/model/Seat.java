package com.flightService.model;

import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "seat")
public class Seat {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "seat_id")
	private Long id;
	
	private int seatNumber;
	
	@ManyToOne
	@JoinColumn(name = "id")
	@JsonManagedReference
	private Flights flight;
	
	@OneToMany(mappedBy = "seat", cascade = CascadeType.ALL)
	@JsonBackReference
	private Set<SeatBooked> bookedSeats;
	
	
}
