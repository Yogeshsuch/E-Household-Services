import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/app/user.service';
import { OrderService } from 'src/app/order.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.css']
})
export class UserProfileComponent implements OnInit {

  name;
  email;
  mobileNo;
  address;
  zip;
  locality;
  city;
  state;
  userId : number;
  orders = [];
 
  constructor(private service : UserService, private orderService : OrderService, private route : Router) {
    this.userId = sessionStorage['user'];
    this.getUserDetails(this.userId);
    this.orderDetails(this.userId);

   }

   getUserDetails(id){
      this.service.getUserDetails(id)
      .subscribe(response=>{
         const data = response.json();
          this.name = data['name'];
          this.email = data['email'];
          this.mobileNo= data['mobileNo'];
          this.address= data['address'];
          this.zip= data['zip'];
          this.locality = data['locality'];
          this.city = data['city'];
          this.state = data['state'];
          console.log(this.name,this.email,this.mobileNo);
      })
   }

   orderDetails(id){
    this.service.getOrderDetails(id)
    .subscribe(response=>{
      const data = response.json(); 
      console.log(data);
      this.orders = data;
    })
 }

 cancelOrder(oid){
      this.orderService.cancelOrder(oid)
      .subscribe(response=>{
        alert("Order cancelled successfully");
        this.orderDetails(this.userId);
      })
 }

 frontPage(){
    this.route.navigate(['/index']);
 }

 update(){
  this.route.navigate(['/u-edit'], {queryParams:{id:this.userId}});
 }
  ngOnInit() {
  }

}
