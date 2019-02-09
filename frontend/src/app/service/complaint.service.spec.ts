import { TestBed } from '@angular/core/testing';

import { ComplaintService } from './complaint.service';

describe('ComplaintService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: ComplaintService = TestBed.get(ComplaintService);
    expect(service).toBeTruthy();
  });
});
