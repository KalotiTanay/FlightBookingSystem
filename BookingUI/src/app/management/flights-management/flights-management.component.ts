import { Component, OnInit } from '@angular/core';
import { FormControl, Validators } from '@angular/forms';
import { FlightsService } from 'src/app/services/flights.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-flights-management',
  templateUrl: './flights-management.component.html',
  styleUrls: ['./flights-management.component.css']
})
export class FlightsManagementComponent implements OnInit {

  public flight={
    flightname:'',
    src_loc:'',
    dest_loc:'',
    company:'',
    capacity:47,
  }

  hide=true;
  flightID: any=0;

    flightname = new FormControl('', [Validators.required]);
    src_loc = new FormControl('', [Validators.required]);
    dest_loc = new FormControl('', [Validators.required]);
    company = new FormControl('', [Validators.required]);

  constructor(public flightService:FlightsService) { }

  ngOnInit(): void {
  }

  flightSubmit() {
    if (this.flight.flightname.trim()=='' || this.flight.flightname.trim()==null){
      return;
    }
    if (this.flight.src_loc.trim()=='' || this.flight.src_loc.trim()==null){
      return;
    }
    if (this.flight.dest_loc.trim()=='' || this.flight.dest_loc.trim()==null){
      return;
    }
    if (this.flight.company.trim()=='' || this.flight.company.trim()==null){
      return;
    }

    this.flightService.createFlight(this.flight).subscribe(
      (data: any)=>{
        // if success
        console.log(data);
        Swal.fire({icon: 'success', title: 'Success', text: 'Flight registered successfully !'});
      },
      (error)=>{
        // if unsuccessful
        console.log(error);
        Swal.fire({icon: 'error', title: 'Error', text: 'Something went wrong !!'});
      }
    )
  }

  flightDelete(){
    this.flightService.deleteFlight(this.flightID).subscribe(
      (data:any)=>{
        Swal.fire({icon: 'success', title: 'Success', text: 'Flight deleted successfully !'});
      }
    )
  }

}

