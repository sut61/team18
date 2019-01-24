import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MainMaidComponent } from './main-maid.component';

describe('MainMaidComponent', () => {
  let component: MainMaidComponent;
  let fixture: ComponentFixture<MainMaidComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MainMaidComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MainMaidComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
