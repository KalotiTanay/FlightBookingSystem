import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import baseUrl from './helper';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(private http: HttpClient) { }

  public validateUser(userCred: any) {
    return this.http.post(`${baseUrl}/api/signin`, userCred);
  }

  // logged user will store token in local storage
  public loggedUser(token: any) {
    localStorage.setItem("token", token);
    return true;
  }

  // Is the user logged in method
  public isLoggedIn() {
    let tokenStr = localStorage.getItem("token");
    if (tokenStr == undefined || tokenStr == '' || tokenStr == null){
      return false;
    }

    else return true;
  }

  // Logout Functionality
  public logout() {
    localStorage.removeItem("token");
    localStorage.removeItem("user");
    return true;
  }

  // Get token from local storage
  public getToken() {
    return localStorage.getItem("token");
  }

  // Setting user details
  public setDetails(user: any) {
    localStorage.setItem("user", JSON.stringify(user))
  }

   // Get user details from local storage
   public getUser() {
    let userStr = localStorage.getItem("user");
    if(userStr != null){
      return JSON.parse(userStr);
    } else {
      this.logout();
      return null;
    }
  }

  public getUserid() {
    let user = this.getUser();
    return user.id;
  }

  // Get user authority
  public getAuthority() {
    let user = this.getUser();
    return user.roles[0];
  }

}
