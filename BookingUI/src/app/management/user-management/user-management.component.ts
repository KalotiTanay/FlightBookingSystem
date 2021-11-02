import { Component, OnInit } from '@angular/core';
import { FormControl, Validators } from '@angular/forms';
import { UserService } from 'src/app/services/user.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-user-management',
  templateUrl: './user-management.component.html',
  styleUrls: ['./user-management.component.css']
})
export class UserManagementComponent implements OnInit {

  constructor(private userService: UserService) { }

  public user = {
    firstname:'',
    lastname:'',
    email:'',
    username:'',
    password:''
  }

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

}
