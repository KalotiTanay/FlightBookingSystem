import { Component, OnInit } from '@angular/core';
import { FlightsService } from '../services/flights.service';

@Component({
  selector: 'app-booking',
  templateUrl: './booking.component.html',
  styleUrls: ['./booking.component.css']
})



export class BookingComponent implements OnInit {

  departures: any;
  departure: String="";

  constructor(public flightsService: FlightsService) { }

  ngOnInit() {
    this.allDepartures();
  }

  allDepartures() {
    this.flightsService.getSource().subscribe(
      (data: any)=>{
        this.departures = data;
        console.log(data);
      },
      (error)=>{
        // if unsuccessful
        console.log(error);
      }
    )
  }

}
