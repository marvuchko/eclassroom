import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
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
  constructor(private data: LecturesDataService) {}

  ngOnInit() {
    this.lectures$ = this.data.getLectures();
  }
}
