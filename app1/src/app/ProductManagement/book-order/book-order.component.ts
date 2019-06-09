import { Component, OnInit } from '@angular/core';
import {FormControl} from '@angular/forms';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-book-order',
  templateUrl: './book-order.component.html',
  styleUrls: ['./book-order.component.css']
})
export class BookOrderComponent implements OnInit {

  address : string;
  eTime : string;
  eDate : string;
  issue : string;
  service : string;
  serviceId : number;
  spinners = true;
  constructor(private activeRoute : ActivatedRoute) {

    activeRoute.queryParams.subscribe(param=>{
        if(param['id'] == 10){
          this.service = 'Electrical';
        }else if(param['id'] == 20){
          this.service = 'Plumbing';
        }else if(param['id'] == 30){
          this.service = 'AC & Refrigeration';
        }
    })
    
   }

   myRecaptcha = new FormControl(false);
  onScriptLoad() {
    console.log('Google reCAPTCHA loaded and is ready for use!')
  }

  onScriptError() {
    console.log('Something went long when loading the Google reCAPTCHA')
  }

  test(event:any){
    console.log(`test`);
    console.log(event.target.value);
    const value = event.target.value;
    if (!value) {
      console.log(`invalid`);
      }
  
      if (value < 12) {
        console.log(`To early`);
      }
      if (value > 13) {
        alert('To late');
      }
  }
  
  ngOnInit() {
  }

}
