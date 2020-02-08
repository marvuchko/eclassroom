import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { finalize, catchError } from 'rxjs/operators';
import { NgxSpinnerService } from 'ngx-spinner';
import { LecturesDataService } from '../lectures-data.service';
import { Lecture } from 'src/app/models/lecture';

@Component({
  selector: 'app-lectures-list',
  templateUrl: './lectures-list.component.html',
  styleUrls: ['./lectures-list.component.scss']
})
export class LecturesListComponent implements OnInit {
  lectures$: Observable<Lecture[]>;
  displayedColumns = ['title', 'description', 'createdAt', 'tutor', 'actions'];

  constructor(private data: LecturesDataService, private spinner: NgxSpinnerService) { }

  ngOnInit() {
    this.loadLectures();
  }

  deleteLecture(event: Event, lecture: Lecture) {
    event.stopPropagation();
    event.preventDefault();
    this.spinner.show();
    this.data.deleteLecture(lecture.id).pipe(
      finalize(() => this.spinner.hide()),
      catchError(err => {
        alert('Failed to delete lecture');
        throw err;
      })
    ).subscribe(() => this.loadLectures());
  }

  private loadLectures() {
    this.spinner.show();
    this.lectures$ = this.data.getLectures().pipe(
      finalize(() => this.spinner.hide()),
      catchError(err => {
        alert('Failed to load lectures. Check console for more info');
        throw err;
      }));
  }
}
