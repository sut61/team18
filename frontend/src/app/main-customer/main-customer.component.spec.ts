import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MainCustomerComponent } from './main-customer.component';

describe('MainCustomerComponent', () => {
  let component: MainCustomerComponent;
  let fixture: ComponentFixture<MainCustomerComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MainCustomerComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MainCustomerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
