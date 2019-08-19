import { Component, OnInit } from '@angular/core';
import { AdminService } from 'src/app/admin.service';

@Component({
  selector: 'app-admin-orders',
  templateUrl: './admin-orders.component.html',
  styleUrls: ['./admin-orders.component.css']
})
export class AdminOrdersComponent implements OnInit {

  orders = [];
  constructor(private service : AdminService) {
    this.ordersInfo();
   }

  ordersInfo(){
    this.service
      .getOrders()
      .subscribe(response => {
        const body = response.json();
        this.orders = body;
        console.log(response);
      });
  }

  ngOnInit() {
  }

}
