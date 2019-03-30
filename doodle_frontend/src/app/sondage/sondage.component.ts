import { Component, OnInit } from '@angular/core';
import {SondageService} from '../services/sondage-service';
@Component({
  selector: 'app-sondage',
  templateUrl: './sondage.component.html',
  styleUrls: ['./sondage.component.css']
})
export class SondageComponent implements OnInit {
  sondages;

  constructor(private sondageService: SondageService) { }

  ngOnInit() {
    this.sondageService.getAll().subscribe((resultat) => {
      this.sondages = resultat;
      console.log('resultat = ' + JSON.stringify(resultat));
    });
  }

}
