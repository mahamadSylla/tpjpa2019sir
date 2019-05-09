import { Component, OnInit } from '@angular/core';
import { SondageService } from '../services/sondage-service';

@Component({
  selector: 'app-plages',
  templateUrl: './plages.component.html',
  styleUrls: ['./plages.component.css']
})
export class PlagesComponent implements OnInit {
  plages;
  timeSlot;
  constructor(private sondageService: SondageService) { }

  ngOnInit() {
    this.sondageService.getAllPlages().subscribe((resultat) => {
      this.plages = resultat;
      console.log('resultat = ' + JSON.stringify(resultat));
    });    
  }
  addToSurvey(id: string) {
    this.sondageService.getTimeSlot(id).subscribe(myTimeSlot => {
      this.timeSlot = myTimeSlot;
    });
  }

}
