import { Component, OnInit } from '@angular/core';
import { OrderService } from 'src/app/order.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-new-orders',
  templateUrl: './new-orders.component.html',
  styleUrls: ['./new-orders.component.css']
})
export class NewOrdersComponent implements OnInit {

  skill;
  orders = [];
  fid;
  constructor(private service : OrderService, private activeRoute : ActivatedRoute,private router:Router) { 
    activeRoute.queryParams.subscribe(param=>{
      this.skill = param["skill"];
      this.fid =  sessionStorage["freelancer"];
  })
    
  }

  getNewOrders(){
    this.service.getNewOrders(this.skill)
    .subscribe(response=>{
      console.log(response);
      const data = response.json();
      console.log(data);
      this.orders = data;
      console.log(this.orders);
    })
  }

  acceptOrder(id){
      console.log(id);
      const temp = parseInt(this.fid);
      this.service.acceptOrder(id,temp)
    .subscribe(response=>{
      console.log(response);
      alert("Order has been added to your list successfully");
      this.sendEmail(id);
      this.ngOnInit();
    })
  }

  sendEmail(id){
    
  }

  profile(){
    this.router.navigate(['/freelancerProfile']);
  }

  ngOnInit() {
    this.getNewOrders();
  }

}
