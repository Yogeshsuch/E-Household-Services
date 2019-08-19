import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/app/user.service';

@Component({
  selector: 'app-contact-us',
  templateUrl: './contact-us.component.html',
  styleUrls: ['./contact-us.component.css']
})
export class ContactUsComponent implements OnInit {

  oid:String;
  name:String;
  email:String;
  message:String;

  constructor(private service : UserService) { }

  feedbackSubmit() {
    this.service.submitFeedback(this.oid,this.name,this.email,this.message)
    .subscribe(response=>{
      alert('Your feedback has been submitted successfully');
    })
  }


  ngOnInit() {
  }

}
