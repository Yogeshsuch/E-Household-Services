import { Component, OnInit } from '@angular/core';
import {NgbModal} from '@ng-bootstrap/ng-bootstrap';


@Component({
  selector: 'app-register-pop-up',
  templateUrl: './register-pop-up.component.html',
  styleUrls: ['./register-pop-up.component.css']
})
export class RegisterPopUpComponent implements OnInit {

  constructor(private modalService: NgbModal) {
        
   }

  open(content) {
    this.modalService.open(content, {ariaLabelledBy: 'RegisterAs'});
  }

  ngOnInit() {
  }

}
