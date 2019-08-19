import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { UserService } from 'src/app/user.service';

@Component({
  selector: 'app-user-update',
  templateUrl: './user-update.component.html',
  styleUrls: ['./user-update.component.css']
})
export class UserUpdateComponent implements OnInit {
  userId:number;

  name:String;
  mobileNo:String;
  email:String;
  password:String;
  state;
  locality;
  zip;
  address;
  user;
  cid;
  city;

  constructor(private router : Router, private service : UserService, private activeRoute : ActivatedRoute) { 
    activeRoute
    .queryParams
    .subscribe((params)=> {
      this.userId=params.id;
      console.log("In Update : "+this.userId);
      service
      .getUserDetails(this.userId)
      .subscribe(response => {
        const body = response.json();
        console.log(body);
        this.name=body.name;
        this.email=body.email;
        this.mobileNo=body.mobileNo;
        this.password=body.password;
        this.address=body.address;
        this.city=body.city;
        this.zip=body.zip;
        this.state=body.state;
        this.cid=body.cid;
        this.locality=body.locality;
      })
    })
  }

  updateUser() {
    // this.user=JSON.parse(sessionStorage['user']);
    // this.user.name=this.name;
    // this.user.mobileNo=this.mobileNo;
    // this.user.email=this.email;
    // this.user.password=this.password;
    // console.log(this.user);
    this.service
    .updateUser(this.address, this.cid, this.city, this.email, this.locality, this.mobileNo, this.name, this.password, this.state, this.zip)
    .subscribe(response=>{
      console.log(response.status);
      if(response.status==200){
        alert("Your Details have been updated successfully");
        this.router.navigate(["/userProfile"]);
      }
      else{
        alert("Something Went Wrong...");
      }
    })
  }

  ngOnInit() {
  }


}
