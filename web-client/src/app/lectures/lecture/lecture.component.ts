import { finalize } from 'rxjs/operators';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';
import { NgxSpinnerService } from 'ngx-spinner';
import { Lecture } from 'src/app/models/lecture';
import { LecturesDataService } from './../lectures-data.service';

@Component({
  selector: 'app-lecture',
  templateUrl: './lecture.component.html',
  styleUrls: ['./lecture.component.scss']
})
export class LectureComponent implements OnInit {

  lecture$: Observable<Lecture>;

  constructor(private data: LecturesDataService, private route: ActivatedRoute, private spinner: NgxSpinnerService) { }

  ngOnInit() {
    this.route.paramMap.subscribe(params => {
      const id = params.get('id');
      if (!id) {
        throw new Error('Lecture id not provided');
      }
      this.spinner.show();
      this.lecture$ = this.data.getLecture(id).pipe(finalize(() => this.spinner.hide()));
    });
  }

}
