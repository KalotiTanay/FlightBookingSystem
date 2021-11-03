import { Component, OnInit } from '@angular/core';
import { FormControl, Validators } from '@angular/forms';
import { FlightsService } from '../services/flights.service';
import { LoginService } from '../services/login.service';

export interface UserTickets {
    ticket_id:String;
    flight_id:any;
    user_id:String;
    source_loc:String;
    dest_loc:String;
    adults:number;
    childs:number;
}


const TICKET_DATA: UserTickets[]=[];

@Component({
  selector: 'app-my-tickets',
  templateUrl: './my-tickets.component.html',
  styleUrls: ['./my-tickets.component.css']
})
export class MyTicketsComponent implements OnInit {

  ticketId:any;
  constructor(public flightService: FlightsService, private login: LoginService) { }

  ticket_form = new FormControl('', [Validators.required]);
  ngOnInit(): void {
    this.allTickets();
  }

  dataSource: any;

  allTickets(){
    this.flightService.getTickets(this.login.getUserid()).subscribe(
      (TICKET_DATA)=>{
        this.dataSource = TICKET_DATA;
        console.log(TICKET_DATA);
      },
      (error)=>{
        // if unsuccessful
        console.log(error);
      }
    )
  }

}
