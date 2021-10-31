import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminDashboardComponent } from './admin/admin-dashboard/admin-dashboard.component';
import { BookingComponent } from './booking/booking.component';
import { FaqNavComponent } from './faq-nav/faq-nav.component';
import { HomeNavComponent } from './home-nav/home-nav.component';
import { FlightsManagementComponent } from './management/flights-management/flights-management.component';
import { UserManagementComponent } from './management/user-management/user-management.component';
import { MyTicketsComponent } from './my-tickets/my-tickets.component';
import { AdminGuard } from './services/admin.guard';
import { UserGuard } from './services/user.guard';
import { UserDashboardComponent } from './user/user-dashboard/user-dashboard.component';

const routes: Routes = [

  {
    path: 'admin-dashboard',
    component: AdminDashboardComponent,
    children:[
      {
        path: 'home',
        component: HomeNavComponent,
      },
      {
        path: 'ticket-booking',
        component: BookingComponent,
      },
      {
        path: 'my-tickets',
        component: MyTicketsComponent,
      },
      {
        path: 'management/user',
        component: UserManagementComponent,
      },
      {
        path: 'management/flights',
        component: FlightsManagementComponent,
      },
      {
        path: 'FAQs',
        component: FaqNavComponent,
      }
    ],
    canActivate: [AdminGuard]
  },
  {
    path: 'user-dashboard',
    component: UserDashboardComponent,
    children: [
      {
        path: 'home',
        component: HomeNavComponent,
      },
      {
        path: 'ticket-booking',
        component: BookingComponent,
      },
      {
        path: 'my-tickets',
        component: MyTicketsComponent,
      },
      {
        path: 'FAQs',
        component: FaqNavComponent,
      }
    ],
    canActivate: [UserGuard]
  }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
