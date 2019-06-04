import { Component } from '@angular/core';
import {NgbModal} from '@ng-bootstrap/ng-bootstrap';
import { Router } from '@angular/router';
import { UserRegisterComponent } from './UserManagement/user-register/user-register.component';


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

  onCustomerSelect(){
    console.log('user click');
      this.router.navigate(['/userRegister'])
      this.modalService.dismissAll();
  }

  onFreelancerSelect(){
    console.log('frelancer click');
    this.router.navigate(['/freelancerRegister'])
    this.modalService.dismissAll('/freelancerRegister');
  }

}

