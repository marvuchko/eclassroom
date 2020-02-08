import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import { HeaderModule } from './header/header.module';
import { LecturesModule } from './lectures/lectures.module';
import { CoreModule } from './core/core.module';
import { SharedModule } from './shared/shared.module';

@NgModule({
  declarations: [AppComponent],
  imports: [
    AppRoutingModule,
    CoreModule,
    SharedModule,
    HeaderModule,
    LecturesModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
