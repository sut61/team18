import { TestBed } from '@angular/core/testing';

import { LendService } from './lend.service';

describe('LendService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: LendService = TestBed.get(LendService);
    expect(service).toBeTruthy();
  });
});
