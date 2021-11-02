import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import passengersURL from './bookingHelper';
import flightsURL from './flightsHelper';

@Injectable({
  providedIn: 'root'
})
export class FlightsService {

  
  constructor(private http: HttpClient) { }

  // All Flights related operations here.

  public getFlight() {}

  public createFlight(flight:any) {
    return this.http.post(`${flightsURL}/flightService/addFlight`,flight);
  }

  public deleteFlight(flightId:any) {
    return this.http.delete(`${flightsURL}/flightService/deleteFlight/${flightId}`);
  }

  public getSource() {
    return this.http.get(`${flightsURL}/flightService/departures`);
  }

  public getDest() {
    return this.http.get(`${flightsURL}/flightService/landings`);
  }

  public getId(valuea: any, valueb: any) {
    return this.http.get(`${flightsURL}/flightService/flightId/${valuea}/${valueb}`);
  }

  public bookPassenger(passengers:any) {
    return this.http.post(`${passengersURL}/passenger/addPassenger`,passengers);
  }

  public cancelTicket(ticket_id:any) {
    return this.http.delete(`${passengersURL}/passenger/boardingPassenger/deletePassenger/${ticket_id}`);
  }

  public getTickets(user_id:any) {
    return this.http.get(`${passengersURL}/passenger/boardingPassengers/user/${user_id}`);
  }
}
