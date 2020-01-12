import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { FormControl } from '@angular/forms';
import { IStartThreadOptions } from 'src/app/models/start-thread-options';

@Component({
  selector: 'app-ask-question',
  templateUrl: './ask-question.component.html',
  styleUrls: ['./ask-question.component.scss']
})
export class AskQuestionComponent implements OnInit {

  @Input()
  videoId: string;

  @Input()
  videoTimestamp = 0;

  @Input()
  videoDuration = 0;

  @Output()
  askQuestion = new EventEmitter<IStartThreadOptions>();
  
  inEditMode: boolean;
  titleFormControl: FormControl;

  constructor() { }

  ngOnInit() {
    this.titleFormControl = new FormControl();
  }

  startEdit() {
    this.inEditMode = true;
  }

  cancel() {
    this.inEditMode = false;
    this.titleFormControl.setValue(null);
  }

  confirm() {
    if (!this.titleFormControl.value) {
      return;
    }
    const title = this.titleFormControl.value;
    const videoTimestamp = this.videoTimestamp;
    const videoId = this.videoId;
    const authorEmail = prompt('Email');
    const authorName = prompt('Name');
    const options: IStartThreadOptions = {
      videoId,
      title,
      videoTimestamp,
      authorEmail,
      authorName
    };
    this.askQuestion.next(options);
    this.titleFormControl.setValue(null);
    this.inEditMode = false;
  }

}
