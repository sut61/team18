import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LoginAddminComponent } from './login-addmin.component';

describe('LoginAddminComponent', () => {
  let component: LoginAddminComponent;
  let fixture: ComponentFixture<LoginAddminComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LoginAddminComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LoginAddminComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
