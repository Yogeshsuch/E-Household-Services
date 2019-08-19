import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AdminService } from 'src/app/admin.service';

@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.css']
})
export class UserListComponent implements OnInit {

  customers = [];

  constructor(private router : Router, private service : AdminService) {
    this.loadCustomers();
   }

  loadCustomers() {
    console.log("in load customers")
    this.service
      .getCustomers()
      .subscribe(response => {
        const body = response.json();
        this.customers = body;
        console.log(response);
      });
  }

  onDelete(id) {
    console.log(id);
    const result = confirm('Are you sure you want to remove this movie?');
    if (result) {
      this.service
        .deleteCustomer(id)
        .subscribe(response => {
          this.loadCustomers();
        })
    }
  }

  ngOnInit() {
  }


}
