import { Component, OnInit } from '@angular/core';
import {FormControl} from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { OrderService } from 'src/app/order.service';

@Component({
  selector: 'app-book-order',
  templateUrl: './book-order.component.html',
  styleUrls: ['./book-order.component.css']
})
export class BookOrderComponent implements OnInit {

  address : string;
  expectTime : any;
  expectDate : any;
  issue : string;
  service : string;
  serviceId : number;
  mobNumber : string;
  spinners = true;
  userId;
  otpValue : number = 3737;

  constructor(private router : Router,private activeRoute : ActivatedRoute,private modalService : NgbModal, private orderService:OrderService) {

    activeRoute.queryParams.subscribe(param=>{
        if(param['id'] == 10){
          this.service = 'Electrical';
        }else if(param['id'] == 20){
          this.service = 'Plumbing';
        }else if(param['id'] == 30){
          this.service = 'AC Refrigeration';
        }  
    })

    this.userId = sessionStorage['user'];

    this.getCustomerDetails(this.userId);
    
   }

  myRecaptcha = new FormControl(true);

  orderPlace(){

    if(this.otpValue == 3737)
    {
      this.orderService.post(this.address,this.expectDate,this.expectTime,this.issue,this.service,this.mobNumber)
      .subscribe(response=>{
          console.log(response);
      })
      alert("Order placed Sucessfully...");
      this.closeAll();
      this.router.navigate(['/userProfile']);
    }

    

  }
  
  getCustomerDetails(userId){
    this.orderService.getDetails(userId)
    .subscribe(response=>{
      
      const data = response.json();
      this.address = data['address'];
      this.mobNumber = data['mobileNo'];
      console.log(this.address);
    })
  }
  
  onScriptLoad() {
    console.log('Google reCAPTCHA loaded and is ready for use!')
  }

  onScriptError() {
    console.log('Something went long when loading the Google reCAPTCHA')
  }

  openPopUp(content){

    if(this.myRecaptcha['status'] == 'VALID'){
      this.modalService.open(content, {ariaLabelledBy: 'otp'});
    } 
    else
        alert("Please select recaptcha");
    
  }
  
  closeAll(){
    this.modalService.dismissAll();
  }

  

  ngOnInit() {
  }

}
