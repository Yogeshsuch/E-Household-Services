import { Component, OnInit } from '@angular/core';
import { FreelancerService } from 'src/app/freelancer.service';
import { Router } from '@angular/router';

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
  address : string;
  thumbnail = [];
  temp : boolean;

  services = [];

  constructor(private service : FreelancerService, private router: Router) {
    this.selectSkill();
   }

  ngOnInit() {
  }

  onRegister(){
      this.service.post(this.thumbnail,this.fullName,this.password,this.email,this.mobileNumber,this.address,this.zipCode,this.locality,this.city,this.state,this.serviceSelected)
      .subscribe(response=>{
      console.log(response);
      alert("Register successfully");
      this.router.navigate(['/index']);
    })
  }

  selectSkill(){
    this.service.getSkill()
    .subscribe(response=>{
      const data = response.json();
      let index = 1;
      this.services[0] = "Select service";
      data.forEach(element => {
          this.services[index] = element.skill;
          index = index + 1;
      });
      
    })
  }

  onSelectImage(event) { 
    this.thumbnail = event.target.files[0];
    console.log(this.thumbnail);
  }


  onZipInsert(zip:any){
    if(zip.target.value.length == 6)
      {
        console.log(zip.target.value);
        this.service.get(zip.target.value)
        .subscribe(response => {
          const body = response.json();
          console.log(body); 
          this.locality = body["locality"];
          this.city = body["city"];
          this.state = body["state"];
        });
      }
  }

  skillSelect(event :any){
      this.serviceSelected = event.target.value;
  }

}
