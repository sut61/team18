import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MaidselectComponent } from './maidselect.component';

describe('MaidselectComponent', () => {
  let component: MaidselectComponent;
  let fixture: ComponentFixture<MaidselectComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MaidselectComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MaidselectComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
