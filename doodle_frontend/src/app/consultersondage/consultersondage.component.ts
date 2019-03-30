import { Component, OnInit } from '@angular/core';
import {ActivatedRoute} from '@angular/router';
import {SondageService} from '../services/sondage-service';

@Component({
  selector: 'app-consultersondage',
  templateUrl: './consultersondage.component.html',
  styleUrls: ['./consultersondage.component.css']
})
export class ConsultersondageComponent implements OnInit {

  sondage;


  constructor(private route: ActivatedRoute, private sondageService: SondageService) {
    let id = route.snapshot.paramMap.get('id');
    sondageService.getSondageById(id).subscribe((monSondage) => this.sondage = monSondage);
  }

  ngOnInit() {
  }

}
