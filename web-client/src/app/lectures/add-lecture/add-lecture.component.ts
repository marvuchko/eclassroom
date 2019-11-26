import { LecturesDataService } from './../lectures-data.service';
import { Lecture } from './../../models/lecture';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-add-lecture',
  templateUrl: './add-lecture.component.html',
  styleUrls: ['./add-lecture.component.scss']
})
export class AddLectureComponent implements OnInit {

  selectedVideo: File;
  constructor(private lectureService: LecturesDataService) { }

  ngOnInit() {
  }

  onFileChange(file: File) {
    this.selectedVideo = file;
  }

  submit() {
    alert('Not impleted yet!');
  }

}
