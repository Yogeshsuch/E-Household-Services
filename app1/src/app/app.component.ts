import { Component } from '@angular/core';
import {NgbModal} from '@ng-bootstrap/ng-bootstrap';
import { Router } from '@angular/router';
import { UserService } from './user.service';
import { FreelancerService } from './freelancer.service';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  isNavbarCollapsed = true;
  title = 'HomeKhas';
  email;
  password;
  validUser:boolean = false;
  InvalidUser:boolean = true;
  userRole = false;
  freelancerRole = false;
  constructor(private modalService : NgbModal,private router:Router, private userService : UserService,private freelancerService : FreelancerService)
  {
      if(sessionStorage['login_status'] == 1 || sessionStorage['freelancer_login_status'] == 1){
        this.validUser = true;
        this.InvalidUser = false;
      }
      
  }

  openPopUp(content){
    
    this.modalService.open(content, {ariaLabelledBy: 'RegisterAs'});
    
  }

  closeAll(){
    this.modalService.dismissAll();
  }

  onCustomerSelect(){
      this.router.navigate(['/userRegister'])
      this.closeAll();
  }

  onFreelancerSelect(){
    this.router.navigate(['/freelancerRegister'])
    this.modalService.dismissAll('/freelancerRegister');
    this.closeAll();
  }

  userLogin(){
    this.userService.userLogin(this.email,this.password)
    .subscribe(response=>{

        // console.log(response["_body"]);
        const body = response.json();
        
          if(body != null){
            this.validUser = true;
            this.InvalidUser = false;
            sessionStorage['login_status'] = '1';
            sessionStorage['user'] = response["_body"];
            sessionStorage['role'] = "user";
            this.userRole = true;
            this.closeAll();
            this.router.navigate(['/frontPage'], {queryParams:{'id':response["_body"]}});
        }
        else {
          alert('Invalid password or username');
        }
    })
  }

  freelancerLogin(){

    this.freelancerService.freelancerLogin(this.email,this.password)
    .subscribe(response=>{
        const body = response.json();
          if(body != null){
            this.validUser = true;
            this.InvalidUser = false;
            sessionStorage['freelancer_login_status'] = '1';
            sessionStorage['freelancer'] = response["_body"];
            sessionStorage['role'] = "freelancer";
            console.log( sessionStorage['role']);
            this.freelancerRole = true;
            this.closeAll();
            this.router.navigate(['/frontPage'], {queryParams:{'id':response["_body"]}});
        }
        else {
          alert('Invalid password or username or login after verification');
        }
    })

  }


  logout(){
    this.validUser = false;
    this.InvalidUser = true;
    sessionStorage['login_status'] = '0';
    sessionStorage['freelancer_login_status'] = '0';
    sessionStorage['role'] == "";
      this.router.navigate(['/userProfile']);

    this.router.navigate(['/frontPage']);
  }

  profile(){
    if(sessionStorage['role'] == "user")
    {
      this.router.navigate(['/userProfile']);
    }
    else if(sessionStorage['role'] == "freelancer"){
      this.router.navigate(['/freelancerProfile']);
    }else{
      alert("Login as user or freelancer");
    }
      

  }

}

