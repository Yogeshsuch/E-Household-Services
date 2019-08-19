import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import{ NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';

import { AppComponent } from './app.component';
import { FrontPageComponent } from './front-page/front-page.component';
import { UserRegisterComponent } from './UserManagement/user-register/user-register.component';
import { UserLoginComponent } from './UserManagement/user-login/user-login.component';
import {MatDialogModule, MatFormFieldModule} from '@angular/material';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { RegisterPopUpComponent } from './PopUps/register-pop-up/register-pop-up.component';
import { FreelancerRegisterComponent } from './UserManagement/freelancer-register/freelancer-register.component';
import { BookOrderComponent } from './ProductManagement/book-order/book-order.component';
import { FreelancerLoginComponent } from './UserManagement/freelancer-login/freelancer-login.component';
import { RecaptchaModule } from 'angular-google-recaptcha';
import { ReactiveFormsModule } from '@angular/forms';
import { UserService } from './user.service';
import { UserProfileComponent } from './UserManagement/user-profile/user-profile.component';
import { FreelancerProfileComponent } from './UserManagement/freelancer-profile/freelancer-profile.component';
import { NewOrdersComponent } from './ProductManagement/new-orders/new-orders.component';
import { AdminDashboardComponent } from './UserManagement/admin-dashboard/admin-dashboard.component';
import { FeedbacksComponent } from './UserManagement/feedbacks/feedbacks.component';
import { AdminLoginComponent } from './UserManagement/admin-login/admin-login.component';
import { UserListComponent } from './UserManagement/user-list/user-list.component';
import { AboutUsComponent } from './UserManagement/about-us/about-us.component';
import { ContactUsComponent } from './UserManagement/contact-us/contact-us.component';
import { AdminOrdersComponent } from './UserManagement/admin-orders/admin-orders.component';
import { UserUpdateComponent } from './UserManagement/user-update/user-update.component';


@NgModule({
  declarations: [
    AppComponent,
    FrontPageComponent,
    UserRegisterComponent,
    UserLoginComponent,
    RegisterPopUpComponent,
    FreelancerRegisterComponent,
    BookOrderComponent,
    FreelancerLoginComponent,
    UserProfileComponent,
    FreelancerProfileComponent,
    NewOrdersComponent,
    AdminDashboardComponent,
    FeedbacksComponent,
    AdminLoginComponent,
    UserListComponent,
    AboutUsComponent,
    ContactUsComponent,
    AdminOrdersComponent,
    UserUpdateComponent
  ],
  imports: [
    BrowserModule,
    HttpModule,
    MatDialogModule,
    BrowserAnimationsModule,
    MatFormFieldModule,
    FormsModule,ReactiveFormsModule,
    NgbModule.forRoot(),
    RouterModule.forRoot([
      {path:'index',component:FrontPageComponent},
      {path:'',redirectTo:'/index',pathMatch:'full'},
      {path:'userRegister',component:UserRegisterComponent},
      {path:'bookOrder',component:BookOrderComponent, canActivate: [UserService]},
      {path:'Userlogin',component: UserLoginComponent},
      {path:'FreelancerLogin', component:FreelancerLoginComponent},
      {path:'freelancerRegister', component:FreelancerRegisterComponent},
      {path:'frontPage', component:FrontPageComponent},
      {path:'userProfile', component:UserProfileComponent},
      {path:'freelancerProfile', component:FreelancerProfileComponent},
      {path:'pool', component:NewOrdersComponent},
      {path:'dashboard', component:AdminDashboardComponent},
      {path:'feedback', component:FeedbacksComponent},
      {path:'admin-login', component:AdminLoginComponent},
      {path:'userlist', component:UserListComponent},
      {path:'about-us', component:AboutUsComponent},
      {path:'contact', component:ContactUsComponent},
      {path:'a-orders', component:AdminOrdersComponent},
      {path:'u-edit', component:UserUpdateComponent}
    ]),
    RecaptchaModule.forRoot({
      siteKey: '6Lck4qcUAAAAAO3poAcff6pQgctZSkzGTlrnKtLz'
    }),
  ],
  providers: [],
  bootstrap: [AppComponent],
  entryComponents:[UserRegisterComponent]
})
export class AppModule { }
