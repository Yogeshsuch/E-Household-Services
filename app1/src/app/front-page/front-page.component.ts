import { Component, OnInit } from '@angular/core';
import { MatDialog, MatDialogConfig } from '@angular/material'
import { UserRegisterComponent } from '../UserManagement/user-register/user-register.component';
import { Router } from '@angular/router';

@Component({
  selector: 'app-front-page',
  templateUrl: './front-page.component.html',
  styleUrls: ['./front-page.component.css']
})
export class FrontPageComponent implements OnInit {


  images = ['/assets/carousel_1.jpg','/assets/Home3.jpg','/assets/Home1.jpg','/assets/carousel_2.jpg'];

  constructor(private matDialog:MatDialog, private router:Router) { }

  ngOnInit() {
  }

  onBookOrder(id){
    
      this.router.navigate(['./bookOrder'], {queryParams:{'id':id}});
  }

  onRegister(){
    const dialogConfig  = new MatDialogConfig();
    dialogConfig.height = '600px';
    dialogConfig.autoFocus = true;
    dialogConfig.disableClose = true;
    this.matDialog.open(UserRegisterComponent);
  }
}
