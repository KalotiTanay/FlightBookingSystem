import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import flightsURL from './flightsHelper';

@Injectable({
  providedIn: 'root'
})
export class FlightsService {

  constructor(private http: HttpClient) { }

  // All Flights related operations here.

  public getFlight() {}

  public getSource() {
    return this.http.get(`${flightsURL}/flightService/departures`);
  }
}
