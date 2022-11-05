import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { VagasRoutingModule } from './vagas-routing.module';
import { VagasComponent } from './vagas.component';


@NgModule({
  declarations: [
    VagasComponent
  ],
  imports: [
    CommonModule,
    VagasRoutingModule
  ]
})
export class VagasModule { }
