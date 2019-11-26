import { TestBed } from '@angular/core/testing';

import { LecturesDataService } from './lectures-data.service';

describe('LecturesDataService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: LecturesDataService = TestBed.get(LecturesDataService);
    expect(service).toBeTruthy();
  });
});
