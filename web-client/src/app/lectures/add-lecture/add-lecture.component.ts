import { finalize, catchError, tap } from 'rxjs/operators';
import { NgxSpinnerService } from 'ngx-spinner';
import { IAddLectureOptions } from './../../models/add-lecture-options';
import { LecturesDataService } from './../lectures-data.service';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, FormControl, Validators } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-add-lecture',
  templateUrl: './add-lecture.component.html',
  styleUrls: ['./add-lecture.component.scss']
})
export class AddLectureComponent implements OnInit {

  addLectureGroup: FormGroup;

  constructor(
    private lectureService: LecturesDataService, private fb: FormBuilder, private spinner: NgxSpinnerService,
    private router: Router) { }

  ngOnInit() {
    this.addLectureGroup = this.fb.group({
      title: new FormControl(null, Validators.required),
      description: new FormControl(null, Validators.required),
      author: new FormControl(null, Validators.required),
      email: new FormControl(null, [Validators.required, Validators.email]),
      video: new FormControl(null, Validators.required)
    });
  }

  onFileChange(file: File) {
    this.addLectureGroup.get('video').setValue(file);
  }

  submit() {
    if (this.addLectureGroup.invalid) {
      alert('Please fill missing fields');
      return;
    }
    const options: IAddLectureOptions = {
      fullName: this.addLectureGroup.get('author').value,
      description: this.addLectureGroup.get('description').value,
      durationInSeconds: 0,
      email: this.addLectureGroup.get('email').value,
      title: this.addLectureGroup.get('title').value,
      thumbnail: new File([], 'thumbnail.jpg'),
      video: this.addLectureGroup.get('video').value,
      videoTitle: this.addLectureGroup.get('title').value
    };
    this.spinner.show();
    this.lectureService.addLecture(options).pipe(
      finalize(() => this.spinner.hide()),
      catchError(err => {
        alert('Failed to add lecture');
        throw err;
      }),
      tap(() => {
        this.router.navigateByUrl('/');
      })
    ).subscribe(() => { });
  }

}
