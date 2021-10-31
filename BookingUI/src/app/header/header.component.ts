import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { AdminDashboardComponent } from '../admin/admin-dashboard/admin-dashboard.component';
import { LoginDialogComponent } from '../login-dialog/login-dialog.component';
import { LoginService } from '../services/login.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  constructor(public dialog: MatDialog, public login: LoginService) {}
  
  openDialog() {
    this.dialog.open(LoginDialogComponent);
  }

  logoutUser() {
    this.login.logout();
    window.location.reload();
  }

  ngOnInit(): void {
  }

}
