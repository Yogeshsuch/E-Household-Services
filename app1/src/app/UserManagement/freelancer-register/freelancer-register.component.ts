import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-freelancer-register',
  templateUrl: './freelancer-register.component.html',
  styleUrls: ['./freelancer-register.component.css']
})
export class FreelancerRegisterComponent implements OnInit {

  serviceSelected : string;
  fullName : string;
  email : string;
  mobileNumber : string;
  zipCode : number;
  locality : string;
  city : string;
  state : string;
  password : string;
  confirmPassword : string;
  address : string;
  thumbnail : string;

  services = ['Electrical','Plumbing','Ac & Refrigeration'];

  constructor() {
    
   }

  ngOnInit() {
  }

  onRegister(){

    //here we get selected service
    console.log(this.serviceSelected);
    console.log(this.mobileNumber);
    console.log(this.fullName);
    console.log(this.email);
    console.log(this.password);
  }

}
