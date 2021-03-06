import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import baseUrl from './helper';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient) { }


  // USer related operations here.

  public addUser(user: any) {
    return this.http.post(`${baseUrl}/api/signup`, user);
  }

  public deleteUser(user_id: String) {
    return this.http.delete(`${baseUrl}/user/delete/${user_id}`);
  }

}
