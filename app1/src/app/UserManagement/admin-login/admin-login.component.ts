import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AdminService } from 'src/app/admin.service';

@Component({
  selector: 'app-admin-login',
  templateUrl: './admin-login.component.html',
  styleUrls: ['./admin-login.component.css']
})
export class AdminLoginComponent implements OnInit {

  email = '';
  password = '';
  
  constructor(private router : Router, private service : AdminService) { 
  }

  onAdminLogin(){
    if (this.email.length == 0) {
      console.log(this.email); 
      alert('enter email');
    } else if (this.password.length == 0) {
      alert('enter password');
    } else {
      this.service
        .login(this.email, this.password)
        .subscribe(response => {
          const body = response.json();
          console.log(body);
          console.log(response);
          if (body != null) {
            sessionStorage['validUser'] = true;
            sessionStorage['invalidUser'] = false;
            sessionStorage['login_status'] = '1';
            console.log(response["_body"]);
            sessionStorage['uId'] = response["_body"];
            alert('welcome to the app');
            // document.getElementById("loginbtn").setAttribute("Style", "display:none");
            // document.getElementById("logoutbtn").setAttribute("Style", "display:block");
            console.log(sessionStorage['invalidUser']+" "+sessionStorage['validUser']+" "+sessionStorage['login_status']);
            console.log(sessionStorage['uId']);
            this.router.navigate(['/dashboard'], {queryParams:{'id':response["_body"]}});
          } else {
            alert('Invalid username and password');  
          }
        });
        console.log(sessionStorage);
      }
    }
  ngOnInit() {
  }

}
