import { Component, OnInit } from '@angular/core';
import { MatDialog, MatDialogConfig } from '@angular/material'
import { UserRegisterComponent } from '../UserManagement/user-register/user-register.component';

@Component({
  selector: 'app-front-page',
  templateUrl: './front-page.component.html',
  styleUrls: ['./front-page.component.css']
})
export class FrontPageComponent implements OnInit {

  constructor(private matDialog:MatDialog) { }

  ngOnInit() {
  }

  onRegister(){
    const dialogConfig  = new MatDialogConfig();
    dialogConfig.height = '600px';
    dialogConfig.autoFocus = true;
    dialogConfig.disableClose = true;
    this.matDialog.open(UserRegisterComponent);
  }
}
