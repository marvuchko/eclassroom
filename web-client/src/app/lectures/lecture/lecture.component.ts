import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';
import { finalize, catchError, map, switchMap } from 'rxjs/operators';
import { NgxSpinnerService } from 'ngx-spinner';
import { Lecture } from 'src/app/models/lecture';
import { LecturesDataService } from './../lectures-data.service';
import { SafeResourceUrl } from '@angular/platform-browser';
import { getCuePoints } from 'src/app/video-player/cue-points';

@Component({
  selector: 'app-lecture',
  templateUrl: './lecture.component.html',
  styleUrls: ['./lecture.component.scss']
})
export class LectureComponent implements OnInit {
  lectureData$: Observable<{
    lecture: Lecture;
    videoData: SafeResourceUrl;
    cues: TextTrackCue[];
  }>;
  videoDuration = 0;
  videoTimestamp = 0;

  constructor(
    private data: LecturesDataService,
    private route: ActivatedRoute,
    private spinner: NgxSpinnerService
  ) {}

  ngOnInit() {
    this.route.paramMap.subscribe(params => {
      const id = params.get('id');
      if (!id) {
        throw new Error('Lecture id not provided');
      }
      this.spinner.show();
      const lecture$ = this.data.getLecture(id);
      this.lectureData$ = lecture$.pipe(
        switchMap(lecture => {
          const video = lecture.videos[0];
          const cues = getCuePoints(video.threads);
          const videoData$ = this.getVideoData(video.videoUrl);
          return videoData$.pipe(map(videoData => {
            return {
              lecture, cues, videoData
            }
          }))
        }),
        catchError(err => {
          alert('Failed to load lecture');
          throw err;
        })
      );
    });
  }

  setDuration(duration: number) {
    this.videoDuration = duration;
  }

  setCurrentTime(currentTime: number) {
    this.videoTimestamp = currentTime;
  }

  getVideoData(videoUrl: string): Observable<SafeResourceUrl> {
    this.spinner.show();
    return this.data.getVideoData(videoUrl).pipe(
      finalize(() => this.spinner.hide()),
      catchError(err => {
        alert('Failed to load video');
        throw err;
      })
    );
  }
}
