package com.flightService.model;

import java.time.LocalTime;
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
@Table(name = "booking")
public class Booking {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "booking_id")
	private Long id;
	
	@ManyToOne
    @JoinColumn(name = "screening_id")
    @JsonManagedReference
    private Screening screening;

	@ManyToOne
	@JoinColumn(name = "id")
	@JsonManagedReference
	private Flights flight;
	
	@Column(name = "booking_time")
    private LocalTime bookingTime;

    @Column(name = "is_booked")
    private boolean isBooked;

    @Column(name = "is_active")
    private boolean isActive;

    @OneToMany(mappedBy = "booking", cascade = CascadeType.ALL)
    @JsonBackReference
    private Set<SeatBooked> bookedSeats;

}
