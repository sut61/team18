import { TestBed } from '@angular/core/testing';

import { WelfaresalaryService } from './welfaresalary.service';

describe('WelfaresalaryService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: WelfaresalaryService = TestBed.get(WelfaresalaryService);
    expect(service).toBeTruthy();
  });
});
