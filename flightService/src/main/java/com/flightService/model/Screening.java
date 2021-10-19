package com.flightService.model;

import java.time.LocalDate;
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
@Table(name = "screening")
public class Screening {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "screening_id")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "id")
	@JsonManagedReference
	private Flights flight;
	
	@Column(name = "date")
	private LocalDate date;

    @Column(name = "start_time")
    private LocalTime startTime;

    @Column(name = "end_time")
    private LocalTime endTime;

    @Column(name = "is_full")
    private Boolean isFull;

    @Column(name = "price")
    private Double price;

    @OneToMany(mappedBy = "screening", cascade = CascadeType.ALL)
    @JsonBackReference
    private Set<SeatBooked> bookedSeats;

    @OneToMany(mappedBy = "screening", cascade = CascadeType.ALL)
    @JsonBackReference
    private Set<Booking> bookings;
	
}
