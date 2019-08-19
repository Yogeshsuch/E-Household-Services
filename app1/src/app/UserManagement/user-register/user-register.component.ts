import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/app/user.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-user-register',
  templateUrl: './user-register.component.html',
  styleUrls: ['./user-register.component.css']
})
export class UserRegisterComponent implements OnInit {

  name:String;
  password:String;
  email:String;
  mobileNo:String;
  address:String;
  zip:String;
  locality:String;
  city:String;
  state:String;
 

  constructor(private service : UserService, private router : Router) { }


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
  onSignup(){
    
      this.service.post(this.name,this.password,this.email,this.mobileNo,this.address,this.zip,this.locality,this.city,this.state)
    .subscribe(response=>{
      // const body = response.json();
      // console.log(body);
      alert("Register successfully");
      this.router.navigate(['/index']);
      })
    
  }

  


  ngOnInit() {

  }

}
