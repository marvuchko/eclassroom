import { Component, OnInit, Input } from '@angular/core';
import { VideoThread } from 'src/app/models/video-thread';
import { VideoThreadsDataService } from '../video-threads-data.service';
import { VideoThreadMessage } from 'src/app/models/video-thread-message';

@Component({
  selector: 'app-video-threads',
  templateUrl: './video-threads.component.html',
  styleUrls: ['./video-threads.component.scss']
})
export class VideoThreadsComponent implements OnInit {

  @Input()
  videoThreads: VideoThread[] = [];

  replyThreadId: string = null;

  constructor(private threadsService: VideoThreadsDataService) { }

  ngOnInit() {
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
      complete: () => this.replyThreadId = null,
      next: (message: VideoThreadMessage) => thread.messages.push(message),
      error: (error: any) => {
        console.log(error);
        alert('Failed to reply');
      }
    });
  }
}
