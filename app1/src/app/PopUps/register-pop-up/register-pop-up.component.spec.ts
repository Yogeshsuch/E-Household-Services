import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RegisterPopUpComponent } from './register-pop-up.component';

describe('RegisterPopUpComponent', () => {
  let component: RegisterPopUpComponent;
  let fixture: ComponentFixture<RegisterPopUpComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RegisterPopUpComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RegisterPopUpComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
