import { Component, OnInit } from '@angular/core';
import { Route } from '@angular/compiler/src/core';
import { Router } from '@angular/router';
import { AdminService } from 'src/app/admin.service';

@Component({
  selector: 'app-feedbacks',
  templateUrl: './feedbacks.component.html',
  styleUrls: ['./feedbacks.component.css']
})
export class FeedbacksComponent implements OnInit {
  feedbacks = [];

  constructor(private router : Router, private service : AdminService) { 
    this.loadFeedbacks();
  }

  loadFeedbacks() {
    this.service
      .getFeedbacks()
      .subscribe(response => {
        const body = response.json();
        this.feedbacks = body;
        console.log(response);
        //alert('Your feedback has been submitted successfully');
      })
  }

  ngOnInit() {
  }


}
