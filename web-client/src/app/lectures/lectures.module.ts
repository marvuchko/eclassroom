import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { LecturesListComponent } from './lectures-list/lectures-list.component';
import { LectureComponent } from './lecture/lecture.component';
import { AddLectureComponent } from './add-lecture/add-lecture.component';
import { LecturesRoutingModule } from './lectures-routing.module';

@NgModule({
  declarations: [LecturesListComponent, LectureComponent, AddLectureComponent],
  imports: [CommonModule, LecturesRoutingModule]
})
export class LecturesModule {}
