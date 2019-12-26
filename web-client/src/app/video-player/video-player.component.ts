import {
  Component,
  OnInit,
  Input,
  ViewChild,
  ElementRef,
  Output,
  EventEmitter
} from '@angular/core';
import { fromEvent } from 'rxjs';
import { first } from 'rxjs/operators';
import { VgAPI } from 'videogular2/core';

export interface ICuePoint {
  id: string;
  title: string;
  description: string;
  src: string;
  href: string;
}

export interface IWikiCue {
  startTime: number;
  endTime: number;
  title: string;
  description: string;
  src: string;
  href: string;
}

@Component({
  selector: 'app-video-player',
  templateUrl: './video-player.component.html',
  styleUrls: ['./video-player.component.scss']
})
export class VideoPlayerComponent implements OnInit {
  @ViewChild('media', { static: false }) set video(
    value: ElementRef<HTMLVideoElement>
  ) {
    if (!value) {
      return;
    }
    value.nativeElement.addEventListener('timeupdate', (event: Event) =>
      this.onTimeUpdate(event)
    );
    fromEvent(value.nativeElement, 'loadedmetadata')
      .pipe(first())
      .subscribe(_ => {
        this.durationChange.next(value.nativeElement.duration);
      });
  }

  api: VgAPI;
  track: TextTrack;

  @Input()
  src: string;

  @Input()
  cues: TextTrackCue[];

  @Output()
  timeUpdate = new EventEmitter<number>();

  @Output()
  durationChange = new EventEmitter<number>();

  constructor() {}

  ngOnInit() {}

  onPlayerReady(api: VgAPI) {
    this.api = api;
    this.track = this.api.textTracks[0];
  }

  onCanPlay() {
    this.addCuePoints(this.cues);
  }

  addCuePoints(cuePoints: TextTrackCue[]) {
    if (!cuePoints || cuePoints.length === 0) {
      return;
    }
    cuePoints.forEach(cp => this.track.addCue(cp));
  }

  private onTimeUpdate(event: any) {
    const currentTime = Math.floor(Number(event.target.currentTime));
    this.timeUpdate.next(currentTime);
  }
}
