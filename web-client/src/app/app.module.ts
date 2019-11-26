import { BrowserModule } from '@angular/platform-browser';
import { NgModule, ErrorHandler } from '@angular/core';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HttpClientModule } from '@angular/common/http';
import { NgxSpinnerModule } from 'ngx-spinner';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AlertingErrorHandler } from './alerting-error-handler';

import { HeaderModule } from './header/header.module';
import { LecturesModule } from './lectures/lectures.module';

@NgModule({
  declarations: [AppComponent],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    HttpClientModule,
    NgxSpinnerModule,
    HeaderModule,
    LecturesModule
  ],
  providers: [{
    provide: ErrorHandler,
    useClass: AlertingErrorHandler
  }],
  bootstrap: [AppComponent]
})
export class AppModule { }
