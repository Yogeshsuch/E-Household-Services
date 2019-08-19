import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AdminService } from 'src/app/admin.service';

@Component({
  selector: 'app-admin-dashboard',
  templateUrl: './admin-dashboard.component.html',
  styleUrls: ['./admin-dashboard.component.css']
})
export class AdminDashboardComponent implements OnInit {

  professionals = [];
  orders = [];
  constructor(private router : Router, private service : AdminService) {
    // this.service = service;
    this.loadProfessionals();
  }

  customersList(){
    this.router.navigate(['/userlist']);
  }

  loadProfessionals() {
    this.service
      .getProfessionals()
      .subscribe(response => {
        const body = response.json();
        this.professionals = body;
        console.log(this.professionals);
      });
  }

  ordersInfo(){
    this.router.navigate(['/a-orders']);
  }

  onVerify(id) {
    console.log(id);
    const result = confirm('Are you sure you want to verify?');
      this.service
        .onVerify(id)
        .subscribe(response => {
          this.router.navigate(['/dashboard']);
          //this.loadProfessionals();
        })
  }

  // addService() {
  //   this.router.navigate(['/add-service']);
  // }

  readFeedback() {
    this.router.navigate(['/feedback']);
  }

  ngOnInit() {
    this.loadProfessionals();
  }

}
