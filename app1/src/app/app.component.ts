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
  title = 'HomeKhas';
  constructor(private modalService : NgbModal,private router:Router){ }

  openPopUp(content){
    this.modalService.open(content, {ariaLabelledBy: 'RegisterAs'});
    
  }

  onCustomerSelect(){
      this.router.navigate(['/userRegister'])
      this.modalService.dismissAll();
  }

}

