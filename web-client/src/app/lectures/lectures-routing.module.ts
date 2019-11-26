import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LecturesListComponent } from './lectures-list/lectures-list.component';
import { AddLectureComponent } from './add-lecture/add-lecture.component';
import { LectureComponent } from './lecture/lecture.component';

const routes: Routes = [
  {
    path: 'lectures',
    component: LecturesListComponent
  },
  {
    path: 'lectures/add',
    component: AddLectureComponent
  },
  {
    path: 'lectures/:id',
    component: LectureComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class LecturesRoutingModule {}
