import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BookOrderComponent } from './book-order.component';

describe('BookOrderComponent', () => {
  let component: BookOrderComponent;
  let fixture: ComponentFixture<BookOrderComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BookOrderComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BookOrderComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
