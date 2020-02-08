import { NgModule } from '@angular/core'
import { LecturesListComponent } from './lectures-list/lectures-list.component'
import { LectureComponent } from './lecture/lecture.component'
import { AddLectureComponent } from './add-lecture/add-lecture.component'
import { LecturesRoutingModule } from './lectures-routing.module'
import { VideoThreadsComponent } from './video-threads/video-threads.component'
import { VideoPlayerModule } from '../video-player/video-player.module'
import { AskQuestionComponent } from './ask-question/ask-question.component'
import { SharedModule } from '../shared/shared.module';

@NgModule({
  declarations: [
    LecturesListComponent,
    LectureComponent,
    AddLectureComponent,
    VideoThreadsComponent,
    AskQuestionComponent,
  ],
  imports: [
    SharedModule,
    VideoPlayerModule,
    LecturesRoutingModule,
  ]
})
export class LecturesModule {}
