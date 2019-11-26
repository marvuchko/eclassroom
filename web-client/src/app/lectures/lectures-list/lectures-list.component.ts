import { Component, OnInit } from '@angular/core';
import { Observable, of } from 'rxjs';
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
  displayedColumns = ['title', 'description', 'createdAt', 'tutor'];

  constructor(private data: LecturesDataService, private spinner: NgxSpinnerService) { }

  ngOnInit() {
    this.spinner.show();
    this.lectures$ = this.data.getLectures().pipe(
      finalize(() => this.spinner.hide()),
      catchError(err => {
        console.log(err);
        alert('Failed to load lectures. Check console for more info');
        return of([]);
      }));
  }
}
