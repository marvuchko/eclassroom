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

  @Input()
  set videoTimestamp(value: number) {
    this._videoTimestamp = value;
    this.triggerFilter();
  }

  get videoTimestamp() {
    return this._videoTimestamp;
  }

  private _videoTimestamp: number;

  currentThreads: VideoThread[] = [];
  replyThreadId: string = null;
  showAll: boolean;

  constructor(private threadsService: VideoThreadsDataService) { }

  ngOnInit() {
    this.currentThreads = this.videoThreads;
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

  onShowAllChange(value: boolean) {
    this.showAll = value;
    this.triggerFilter();
  }

  private triggerFilter() {
    this.currentThreads = this.filterCurrentThreads(this.videoThreads, this.showAll, this.videoTimestamp);
  }

  private filterCurrentThreads(allThreads: VideoThread[], showAll: boolean, timestamp: number, treshold = 5): VideoThread[] {
    if (showAll) {
      return allThreads;
    }
    const byTimestampTreshold = (thread: VideoThread) => Math.abs(thread.videoTimestamp - timestamp) <= treshold
    return allThreads.filter(byTimestampTreshold);
  }
}
