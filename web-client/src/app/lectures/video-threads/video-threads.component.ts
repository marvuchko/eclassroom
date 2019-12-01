import { Component, OnInit, Input } from '@angular/core';
import { FormControl } from '@angular/forms';
import { VideoThread } from 'src/app/models/video-thread';
import { IStartThreadOptions } from 'src/app/models/start-thread-options';
import { VideoThreadsDataService } from '../video-threads-data.service';

@Component({
  selector: 'app-video-threads',
  templateUrl: './video-threads.component.html',
  styleUrls: ['./video-threads.component.scss']
})
export class VideoThreadsComponent implements OnInit {

  @Input()
  videoId: string;

  @Input()
  videoTimestamp = 0;

  @Input()
  videoDuration = 0;

  @Input()
  videoThreads: VideoThread[] = [];

  inEditMode = false;

  replyThreadId: string = null;

  titleFormControl: FormControl;

  constructor(private threadsService: VideoThreadsDataService) { }

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
    const videoId = this.videoId;
    const title = this.titleFormControl.value;
    const videoTimestamp = this.videoTimestamp;
    const authorEmail = prompt('Email');
    const authorFullName = prompt('Name');
    const options: IStartThreadOptions = {
      videoId,
      title,
      videoTimestamp,
      authorEmail,
      authorFullName
    };
    this.threadsService.startThread(options).subscribe({
      error: (error: any) => {
        console.log(error);
        alert('Failed to start new thread');
      }
    });
  }

  startReply(videoThread: VideoThread) {
    this.replyThreadId = videoThread.id;
  }

  cancelReply() {
    this.replyThreadId = null;
  }

  reply(thread: VideoThread, content: string) {
    const authorName = prompt('Name');
    const authorEmail = prompt('Email');
    const threadId = thread.id;
    this.threadsService.postMessage(threadId, authorName, authorEmail, content).subscribe({
      error: (error: any) => {
        console.log(error);
        alert('Failed to reply');
      }
    });
  }


}
