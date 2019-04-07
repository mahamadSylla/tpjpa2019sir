import { Component, OnInit } from '@angular/core';
import {ReunionService} from '../services/reunion.service';

@Component({
  selector: 'app-reunion',
  templateUrl: './reunion.component.html',
  styleUrls: ['./reunion.component.css']
})
export class ReunionComponent implements OnInit {
reunions;
  constructor(private reunionService: ReunionService) { }

  ngOnInit() {
    this.reunionService.getAll().subscribe((resultat) => {
      this.reunions = resultat;
      console.log('resultat = ' + JSON.stringify(resultat));
    });
  }

}
