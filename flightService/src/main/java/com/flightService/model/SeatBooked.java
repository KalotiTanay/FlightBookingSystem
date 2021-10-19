package com.flightService.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "seat_booked")
public class SeatBooked {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "seat_booked_id")
	private long id;
	
	@ManyToOne
	@JoinColumn(name = "seat_id")
	@JsonManagedReference
	private Seat seat;
	
	@ManyToOne
	@JoinColumn(name = "booking_id")
	@JsonManagedReference
	private Booking booking;
	
	@ManyToOne
	@JoinColumn(name = "screening_id")
	@JsonManagedReference
	private Screening screening;
	
}
