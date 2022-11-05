import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { ApiRoutingModule } from './api-routing.module';

import { AppComponent } from './app.component';
import { HeaderComponent } from './components/header/header.component';
import { CardComponent } from './components/card/card.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    CardComponent
  ],
  imports: [
    BrowserModule,
    ApiRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
