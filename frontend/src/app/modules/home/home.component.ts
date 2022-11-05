import { Component } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent {

  searchIcon: string = 'assets/icons/search.svg';
  thunder: string = 'assets/icons/thunder.svg';
  modelHero: string = 'assets/images/model-hero.png';
  job: string = 'assets/icons/job.svg';

}
