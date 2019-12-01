import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { VideoThreadsComponent } from './video-threads.component';

describe('VideoThreadsComponent', () => {
  let component: VideoThreadsComponent;
  let fixture: ComponentFixture<VideoThreadsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ VideoThreadsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(VideoThreadsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
