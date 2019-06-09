import { Component } from '@angular/core';
import {NgbModal} from '@ng-bootstrap/ng-bootstrap';
import { Router } from '@angular/router';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  isNavbarCollapsed = true;
  title = 'HomeKhas';
  constructor(private modalService : NgbModal,private router:Router){ }

  openPopUp(content){
    this.modalService.open(content, {ariaLabelledBy: 'RegisterAs'});
    
  }

  // onCustomerLogin(){
  //   this.router.navigate(['/Userlogin'])
  //   this.modalService.dismissAll();
  // }
  // onFreelancerLogin(){
  //   this.router.navigate(['/FreelancerLogin'])
  //   this.modalService.dismissAll();
  // }

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

}

