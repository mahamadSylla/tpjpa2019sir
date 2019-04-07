import {Component, Input, OnInit} from '@angular/core';
import {UtilisateurService} from '../services/utilisateur-service';
import {ActivatedRoute} from '@angular/router';
@Component({
  selector: 'app-alergies',
  templateUrl: './alergies.component.html',
  styleUrls: ['./alergies.component.css']
})
export class AlergiesComponent implements OnInit {
  @Input("alergies") alergies;
  constructor( private route: ActivatedRoute, private utilisateurService: UtilisateurService) {
  }
  ngOnInit() {
  }

}
