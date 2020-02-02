import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { HeaderComponent } from './header.component';
import { SearchComponent } from './search/search.component';
import { SharedModule } from '../shared/shared.module';

@NgModule({
  declarations: [HeaderComponent, SearchComponent],
  imports: [
    SharedModule,
    RouterModule,
  ],
  exports: [HeaderComponent]
})
export class HeaderModule {}
