import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { WelfareandsalaryComponent } from './welfareandsalary.component';

describe('WelfareandsalaryComponent', () => {
  let component: WelfareandsalaryComponent;
  let fixture: ComponentFixture<WelfareandsalaryComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ WelfareandsalaryComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(WelfareandsalaryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
