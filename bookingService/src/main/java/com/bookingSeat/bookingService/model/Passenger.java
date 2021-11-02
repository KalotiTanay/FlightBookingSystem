package com.bookingSeat.bookingService.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Document(collection = "passengers")
public class Passenger {

    @Id
    private Long ticket_id;
    @NotBlank
    private Long flight_id;

    @NotBlank
    private String user_id;

    private String source_loc;
    private String dest_loc;

    @NotBlank
    private int adults;
    private int childs;

    public Passenger(Long flight_id, String user_id, String source_loc, String dest_loc, int adults, int childs) {
        this.flight_id = flight_id;
        this.user_id = user_id;
        this.source_loc = source_loc;
        this.dest_loc = dest_loc;
        this.adults = adults;
        this.childs = childs;
    }

    public Passenger(String user_id, String source_loc, String dest_loc, int adults, int childs) {
        this.user_id = user_id;
        this.source_loc = source_loc;
        this.dest_loc = dest_loc;
        this.adults = adults;
        this.childs = childs;
    }
}
