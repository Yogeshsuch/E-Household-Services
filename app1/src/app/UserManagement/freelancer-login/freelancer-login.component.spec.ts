import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FreelancerLoginComponent } from './freelancer-login.component';

describe('FreelancerLoginComponent', () => {
  let component: FreelancerLoginComponent;
  let fixture: ComponentFixture<FreelancerLoginComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FreelancerLoginComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FreelancerLoginComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
