import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { VagasRoutingModule } from './vagas-routing.module';
import { VagasComponent } from './vagas.component';
import { CardComponent } from 'src/app/components/card/card.component';


@NgModule({
  declarations: [
    VagasComponent,
    CardComponent
  ],
  imports: [
    CommonModule,
    VagasRoutingModule
  ]
})
export class VagasModule { }
