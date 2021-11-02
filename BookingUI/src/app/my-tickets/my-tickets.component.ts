import { Component, OnInit } from '@angular/core';
import { FlightsService } from '../services/flights.service';
import { LoginService } from '../services/login.service';
import { ticket } from '../services/ticket.model';

@Component({
  selector: 'app-my-tickets',
  templateUrl: './my-tickets.component.html',
  styleUrls: ['./my-tickets.component.css']
})
export class MyTicketsComponent implements OnInit {

  bookedTicket=new ticket();
  tickets: ticket[]=[];

  constructor(public flightService: FlightsService, private login: LoginService) { }

  ngOnInit(): void {

  }

  allTickets(){
    this.flightService.getTickets(this.login.getUser().id).subscribe(
      (data:any)=>{
        console.log(data);
      },
      (error)=>{
        // if unsuccessful
        console.log(error);
      }
    )
  }

  deleteTicket(){
    
  }

}
