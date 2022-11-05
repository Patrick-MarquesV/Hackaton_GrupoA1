import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-card',
  templateUrl: './card.component.html',
  styleUrls: ['./card.component.css']
})
export class CardComponent {

  @Input() cargo: any;
  @Input() salario: any;
  @Input() descricao: any;
  @Input() localidade: any;
  @Input() vagas: any;
  @Input() data: any;

}
