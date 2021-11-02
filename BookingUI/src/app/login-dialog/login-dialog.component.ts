import { Component, OnInit } from '@angular/core';
import { FormControl, Validators } from '@angular/forms';
import { MatDialogRef } from '@angular/material/dialog';
import { UserService } from '../services/user.service';
import { LoginService } from '../services/login.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-login-dialog',
  templateUrl: './login-dialog.component.html',
  styleUrls: ['./login-dialog.component.css']
})
export class LoginDialogComponent implements OnInit {

  constructor(
    private dialogRef: MatDialogRef<LoginDialogComponent>,
    private userService: UserService,
    private loginService: LoginService) { }


  // Data Binding Controllers

  public loginCreds = {
    username:'',
    password:'',
  }

  public user = {
    firstname:'',
    lastname:'',
    email:'',
    username:'',
    password:'',
  }

  // All form controles and validators
    email = new FormControl('', [Validators.required, Validators.email]);
    username = new FormControl('', [Validators.required]);
    password = new FormControl('', [Validators.required]);
    firstname = new FormControl('', [Validators.required]);

    hide=true;

  getUserErrorMessage() {
    if (this.username.hasError('required')) {
      return 'You must Enter Username';
    }

    return this.username.hasError('username') ? 'Not a valid username' : '';
  }

  getNameErrorMessage() {
    if (this.firstname.hasError('required')) {
      return 'Enter your name.'
    }

    return this.firstname.hasError('firstname') ? 'Enter your name' : '';
  }

  getPasswordErrorMessage() {
    
    return this.username.hasError('username') ? 'Enter a valid password' : '';
  }

  getErrorMessage() {
    if (this.email.hasError('required')) {
      return 'You must enter a value';
    }

    return this.email.hasError('email') ? 'Not a valid email' : '';
  }

  ngOnInit(): void {
  }

  loginSubmit() {
    if (this.loginCreds.username.trim()=='' || this.loginCreds.username.trim()==null){
      return;
    }
    if (this.loginCreds.password.trim()=='' || this.loginCreds.password.trim()==null){
      return;
    }

    this.loginService.validateUser(this.loginCreds).subscribe(
      (data: any)=>{
        console.log(data);
        this.loginService.loggedUser(data.accessToken);
        this.loginService.setDetails(data);

        // Authority check and redirect:
        // IF ADMIN -> ADMIN-DASHBOARD
        // IF USER -> USER DASHBOARD

        if(this.loginService.getAuthority() == 'ROLE_ADMIN'){
          // Admin Dashboard
          window.location.href='/admin-dashboard/home';
        }
        else if(this.loginService.getAuthority() == 'ROLE_USER'){
          // User Dashboard
          window.location.href='/user-dashboard/home';
        }
        else{ this.loginService.logout(); }

      },
      (error: any)=>{
        // if unsuccessful
        console.log(error);
        Swal.fire({icon: 'error', title: 'Error', text: 'Something went wrong !!'});
      }
      )

  }

  // Registration form Submission and binding
  registrationSubmit() {
    console.log(this.user);

    // Error Handling
    if (this.user.firstname.trim()=='' || this.user.firstname.trim()==null){
      return;
    }
    if (this.user.email.trim()=='' || this.user.email.trim()==null){
      return;
    }
    if (this.user.username.trim()=='' || this.user.username.trim()==null){
      return;
    }
    if (this.user.password.trim()=='' || this.user.password.trim()==null){
      return;
    }

    // addUser() from user-service returrns observable

    this.userService.addUser(this.user).subscribe(
      (data: any)=>{
        // if success
        console.log(data);
        Swal.fire({icon: 'success', title: 'Success', text: 'User registered successfully !'});
      },
      (error)=>{
        // if unsuccessful
        console.log(error);
        Swal.fire({icon: 'error', title: 'Error', text: 'Something went wrong !!'});
      }
    )

  }

  // Dialog Box Components
  close() {
    this.dialogRef.close();
  }
}
