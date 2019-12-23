import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';
import { finalize, tap, catchError, delay } from 'rxjs/operators';
import { NgxSpinnerService } from 'ngx-spinner';
import { Lecture } from 'src/app/models/lecture';
import { LecturesDataService } from './../lectures-data.service';
import { SafeResourceUrl } from '@angular/platform-browser';

@Component({
  selector: 'app-lecture',
  templateUrl: './lecture.component.html',
  styleUrls: ['./lecture.component.scss']
})
export class LectureComponent implements OnInit {
  lecture$: Observable<Lecture>;
  videoData$: Observable<SafeResourceUrl>;
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
      this.lecture$ = this.data.getLecture(id).pipe(
        tap(
          lecture =>
            (this.videoData$ = this.getVideoData(lecture.videos[0].videoUrl))
        ),
        catchError(err => {
          this.spinner.hide();
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
