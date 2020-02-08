import { NgModule } from '@angular/core'
import { CommonModule } from '@angular/common'
import { NgxSpinnerModule } from 'ngx-spinner'
import { MaterialModule } from './material.module'
import { FormsModule, ReactiveFormsModule } from '@angular/forms'
import { DashPipe } from './dash.pipe';

const modules = [CommonModule, MaterialModule, FormsModule, ReactiveFormsModule, NgxSpinnerModule]
const shared = [DashPipe];

@NgModule({
  declarations: [shared],
  imports: [modules],
  exports: [modules, shared],
})
export class SharedModule {}
