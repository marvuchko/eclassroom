import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MatTableModule } from '@angular/material/table';
import { LecturesListComponent } from './lectures-list/lectures-list.component';
import { LectureComponent } from './lecture/lecture.component';
import { AddLectureComponent } from './add-lecture/add-lecture.component';
import { LecturesRoutingModule } from './lectures-routing.module';

@NgModule({
  declarations: [LecturesListComponent, LectureComponent, AddLectureComponent],
  imports: [CommonModule, LecturesRoutingModule, MatTableModule]
})
export class LecturesModule {}
