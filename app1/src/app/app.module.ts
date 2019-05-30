import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router'
import{ NgbModule } from '@ng-bootstrap/ng-bootstrap'

import { AppComponent } from './app.component';
import { FrontPageComponent } from './front-page/front-page.component';
import { UserRegisterComponent } from './UserManagement/user-register/user-register.component';
import { UserLoginComponent } from './UserManagement/user-login/user-login.component';
import {MatDialogModule, MatFormFieldModule} from '@angular/material';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { RegisterPopUpComponent } from './PopUps/register-pop-up/register-pop-up.component';

@NgModule({
  declarations: [
    AppComponent,
    FrontPageComponent,
    UserRegisterComponent,
    UserLoginComponent,
    RegisterPopUpComponent
  ],
  imports: [
    BrowserModule,
    MatDialogModule,
    BrowserAnimationsModule,
    MatFormFieldModule,
    NgbModule.forRoot(),
    RouterModule.forRoot([
      {path:'index',component:FrontPageComponent},
      {path:'',redirectTo:'/index',pathMatch:'full'},
      {path:'userRegister',component:UserRegisterComponent},
      {path:'register',component:RegisterPopUpComponent}
    ])
  ],
  providers: [],
  bootstrap: [AppComponent],
  entryComponents:[UserRegisterComponent]
})
export class AppModule { }