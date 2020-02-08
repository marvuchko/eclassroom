import { NgModule } from '@angular/core'
import { CommonModule } from '@angular/common'
import { NgxSpinnerModule } from 'ngx-spinner'
import { MaterialModule } from './material.module'
import { FormsModule, ReactiveFormsModule } from '@angular/forms'

const modules = [CommonModule, MaterialModule, FormsModule, ReactiveFormsModule, NgxSpinnerModule]
@NgModule({
  declarations: [],
  imports: [modules],
  exports: [modules],
})
export class SharedModule {}
