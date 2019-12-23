import { Component, OnInit, Input, ViewChild, ElementRef, Output, EventEmitter } from '@angular/core';
import { fromEvent } from 'rxjs';
import { first } from 'rxjs/operators';

@Component({
  selector: 'app-video-player',
  templateUrl: './video-player.component.html',
  styleUrls: ['./video-player.component.scss']
})
export class VideoPlayerComponent implements OnInit {

  @ViewChild('videoControl', {static: false}) set video(value: ElementRef<HTMLVideoElement>) {
    if (!value) {
      return;
    }
    value.nativeElement.addEventListener('timeupdate', (event: Event) => this.onTimeUpdate(event));
    fromEvent(value.nativeElement, 'loadedmetadata').pipe(first()).subscribe(_ => {
      this.durationChange.next(value.nativeElement.duration);
    })
  }
  
  @Input()
  src: string;

  @Output()
  timeUpdate = new EventEmitter<number>();

  @Output()
  durationChange = new EventEmitter<number>();

  constructor() { }

  ngOnInit() {
  }

  private onTimeUpdate(event: any) {
    const currentTime = Math.floor(Number(event.target.currentTime));
    this.timeUpdate.next(currentTime);
  }
}
