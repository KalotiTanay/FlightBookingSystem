package com.bookingSeat.bookingService.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Random;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Document(collection = "passengers")
public class Passenger {

    @Id
    private Long passanger_id;

    @NotBlank
    private Long flight_id;

    @NotBlank
    private String user_name;

    @NotBlank
    @Size(max = 30)
    private String firstname;

    @NotBlank
    @Size(max = 30)
    private String lastname;

    @NotBlank
    private String gender;
    @NotBlank
    private int age;

    private List<Flights> flights;

    public Passenger(long flight_id, String user_name, String firstname, String lastname, String gender, int age) {
        this.flight_id = flight_id;
        this.user_name = user_name;
        this.firstname = firstname;
        this.lastname = lastname;
        this.gender = gender;
        this.age = age;
    }
    public Passenger(long flight_id, String user_name, String firstname, String lastname, String gender, int age, List flights) {
        this.flight_id = flight_id;
        this.user_name = user_name;
        this.firstname = firstname;
        this.lastname = lastname;
        this.gender = gender;
        this.age = age;
        this.flights = flights;
    }
}
