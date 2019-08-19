import { Component, OnInit } from '@angular/core';
import { FreelancerService } from 'src/app/freelancer.service';
import { Router } from '@angular/router';
import { OrderService } from 'src/app/order.service';

@Component({
  selector: 'app-freelancer-profile',
  templateUrl: './freelancer-profile.component.html',
  styleUrls: ['./freelancer-profile.component.css']
})
export class FreelancerProfileComponent implements OnInit {

  orderId = undefined;
  name;
  email;
  mobileNo;
  address;
  zip;
  locality;
  city;
  state;
  skill;
  fid;
  orders = [];
  constructor(private fService : FreelancerService, private router : Router,private service : OrderService) {
      this.fid = sessionStorage['freelancer'];
      console.log(this.fid);
      this.freelancerDetails(this.fid);
      this.acceptedOrders(this.fid);
   }

   ngOnInit() {
  }
  freelancerDetails(fid){
        this.fService.freelancerDetails(fid)
        .subscribe(response=>{
          const data = response.json();
          console.log(data);
          this.name = data['name'];
          this.address = data['address'];
          this.email = data['email'];
          this.city = data['city'];
          this.locality = data['locality'];
          this.mobileNo = data['mobileNo'];
          this.state = data['state'];
          this.zip = data['zip'];
          this.skill = data['skill'];
        })
  }

  orderPool(){
      this.router.navigate(['/pool'], {queryParams:{"skill":this.skill}});
  }

  acceptedOrders(fid){
    this.orderCompleted = undefined;
    const temp = parseInt(fid);
      this.service.acceptedOrders(temp)
      .subscribe(response=>{
        const data = response.json();
        console.log(data);
        this.orders = data;
      })
  }

  orderCompleted(){
    console.log("Inside order completed");
      this.service.orderCompleted(this.orderId)
      .subscribe(response=>{
        this.acceptedOrders(this.fid);
      })
  }

  orderHello()
  {
    console.log('Hello');
    console.log("Inside order completed");
    if(this.orderId != undefined){

      this.service.orderCompleted(this.orderId)
      .subscribe(response=>{
        this.acceptedOrders(this.fid);
      })

    }
    else{
      alert("Enter order id");
    }
      

}
}