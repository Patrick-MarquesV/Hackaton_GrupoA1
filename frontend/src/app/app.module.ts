import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { ApiRoutingModule } from './api-routing.module';

import { AppComponent } from './app.component';
import { HeaderComponent } from './components/header/header.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
  ],
  imports: [
    BrowserModule,
    ApiRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
