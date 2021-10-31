package com.bookingSeat.bookingService.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Document(collection = "passengers")
public class Passenger {

    @NotBlank
    private String flight_id;

    @NotBlank
    private String user_id;

    @NotBlank
    @Size(max = 30)
    @Id
    private String name;

    @NotBlank
    private String gender;
    @NotBlank
    private int age;


    public Passenger(String flight_id, String user_id, String name, String gender, int age) {
        this.flight_id = flight_id;
        this.user_id = user_id;
        this.name = name;
        this.gender = gender;
        this.age = age;
    }
}
