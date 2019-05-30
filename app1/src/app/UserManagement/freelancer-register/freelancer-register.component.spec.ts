import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FreelancerRegisterComponent } from './freelancer-register.component';

describe('FreelancerRegisterComponent', () => {
  let component: FreelancerRegisterComponent;
  let fixture: ComponentFixture<FreelancerRegisterComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FreelancerRegisterComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FreelancerRegisterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
