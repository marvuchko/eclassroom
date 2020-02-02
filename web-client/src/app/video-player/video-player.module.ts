import { NgModule } from '@angular/core';
import { VideoPlayerComponent } from './video-player.component';
import { VgCoreModule } from 'videogular2/core';
import { VgControlsModule } from 'videogular2/controls';
import { VgOverlayPlayModule } from 'videogular2/overlay-play';
import { VgBufferingModule } from 'videogular2/buffering';
import { SharedModule } from '../shared/shared.module';

@NgModule({
  declarations: [VideoPlayerComponent],
  imports: [
    SharedModule,
    VgCoreModule,
    VgControlsModule,
    VgOverlayPlayModule,
    VgBufferingModule
  ],
  exports: [VideoPlayerComponent]
})
export class VideoPlayerModule {}
