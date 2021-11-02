import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { FlightsService } from '../services/flights.service';
import { LoginService } from '../services/login.service';

@Component({
  selector: 'app-booking',
  templateUrl: './booking.component.html',
  styleUrls: ['./booking.component.css']
})



export class BookingComponent implements OnInit {


  // Data Binders
 public passenger={
    user_id:this.login.getUser().id,
    source_loc:'',
    dest_loc:'',
    adults:0,
    childs:0
  }

  myControl = new FormControl('', Validators.required);
  secondControl = new FormControl('', Validators.required);
  thirdControl = new FormControl('', Validators.required);
  fourthControl = new FormControl('', Validators.required);

  departures: any;
  landings: any;
  departure: String="";
  landing: String='';
  flightid: any;

  formToggle: any;

  constructor(public flightsService: FlightsService, private login: LoginService) { }

  ngOnInit() {
    this.allDepartures();
    this.allLandings();
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

  allLandings() {
    this.flightsService.getDest().subscribe(
      (data: any)=>{
        this.landings = data;
        console.log(data);
      },
      (error)=>{
        // if unsuccessful
        console.log(error);
      }
    )
  }

  formSubmit() {    
    this.flightsService.bookPassenger(this.passenger).subscribe(
      (data:any)=>{
        console.log(data);
      }
    )
  }

}
