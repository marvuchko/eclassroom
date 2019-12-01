import { TestBed } from '@angular/core/testing';

import { VideoThreadsDataService } from './video-threads-data.service';

describe('VideoThreadsDataService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: VideoThreadsDataService = TestBed.get(VideoThreadsDataService);
    expect(service).toBeTruthy();
  });
});
