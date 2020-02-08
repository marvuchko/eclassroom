import { NgModule } from '@angular/core'
import { CommonModule } from '@angular/common'
import { FormsModule, ReactiveFormsModule } from '@angular/forms'
import { MatTableModule } from '@angular/material/table'
import { MatInputModule } from '@angular/material/input'
import { MatIconModule } from '@angular/material/icon'
import { MatButtonModule } from '@angular/material/button'
import { MatDividerModule } from '@angular/material/divider'
import { MatFormFieldModule } from '@angular/material/form-field'
import { MatSlideToggleModule } from '@angular/material/slide-toggle'
import { NgxSpinnerModule } from 'ngx-spinner'
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
    // FormsModule,
    // ReactiveFormsModule,
    LecturesRoutingModule,
    // NgxSpinnerModule,
    // MatTableModule,
    // MatInputModule,
    // MatFormFieldModule,
    // MatButtonModule,
    // MatIconModule,
    // MatDividerModule,
    // MatSlideToggleModule,
  ],
})
export class LecturesModule {}
