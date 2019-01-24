import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LoginMaidComponent } from './login-maid.component';

describe('LoginMaidComponent', () => {
  let component: LoginMaidComponent;
  let fixture: ComponentFixture<LoginMaidComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LoginMaidComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LoginMaidComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
