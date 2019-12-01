import { Component, OnInit, ViewChild, ElementRef } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';
import { finalize } from 'rxjs/operators';
import { NgxSpinnerService } from 'ngx-spinner';
import { Lecture } from 'src/app/models/lecture';
import { LecturesDataService } from './../lectures-data.service';

@Component({
  selector: 'app-lecture',
  templateUrl: './lecture.component.html',
  styleUrls: ['./lecture.component.scss']
})
export class LectureComponent implements OnInit {

  @ViewChild('videoControl', {static: false}) set video(value: ElementRef<HTMLElement>) {
    if (!value) {
      return;
    }
    value.nativeElement.addEventListener('timeupdate', (event: Event) => this.videoChange(event));
  }

  lecture$: Observable<Lecture>;
  videoDuration = 0;
  videoTimestamp = 0;

  constructor(private data: LecturesDataService, private route: ActivatedRoute, private spinner: NgxSpinnerService) { }

  ngOnInit() {
    this.route.paramMap.subscribe(params => {
      const id = params.get('id');
      if (!id) {
        throw new Error('Lecture id not provided');
      }
      this.spinner.show();
      this.lecture$ = this.data.getLecture(id).pipe(
        finalize(() => this.spinner.hide())
      );
    });
  }

  videoChange(event: any) {
    this.videoTimestamp = Math.floor(Number(event.target.currentTime));
    this.videoDuration = Math.floor(Number(event.target.duration));
  }

}
