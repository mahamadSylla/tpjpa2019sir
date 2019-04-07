import { Component, OnInit } from '@angular/core';
import {UtilisateurService} from '../services/utilisateur-service';
import {Router} from '@angular/router';
import {ActivatedRoute} from '@angular/router';
import {activateRoutes} from '@angular/router/src/operators/activate_routes';

@Component({
  selector: 'app-utilisateur',
  templateUrl: './utilisateur.component.html',
  styleUrls: ['./utilisateur.component.css']
})
export class UtilisateurComponent implements OnInit {
  utilisateurs;
  alergies;
  roles;
  reunionAssistees;
  reunionManquees;
  sondageCree;
  constructor(private utilisateurService: UtilisateurService, private router: Router,private activaTedRouter: ActivatedRoute) {
  }
  ngOnInit() {
    this.utilisateurService.getAll().subscribe((resultat) => {
      this.utilisateurs = resultat;
    });
  }
  onGetAlergie(id: string) {
    this.utilisateurService.getAlergies(id).subscribe(myAlergeis => {
      this.alergies = myAlergeis;
      console.log(JSON.stringify(myAlergeis));
    });
  }
    onGetRole(id: string) {
      this.utilisateurService.getRole(id).subscribe(myRole => {
        this.roles = myRole;
        console.log(JSON.stringify(myRole));
      });
    }
      onGetReunionManquees(id: string) {
        this.utilisateurService.getReunionManquee(id).subscribe(MyMeeting => {
          this.reunionManquees = MyMeeting;
          console.log(JSON.stringify(MyMeeting));
        });
      }
        onGetReunionAssistees(id: string) {
          this.utilisateurService.getReunionAssistee(id).subscribe(MyMeeting => {
            this.reunionAssistees = MyMeeting;
            console.log(JSON.stringify(MyMeeting));
          });
  }
  onGetSondage(id: string) {
    this.utilisateurService.getSondage(id).subscribe(mySurvey => {
      this.sondageCree = mySurvey;
      console.log(JSON.stringify(mySurvey));
    });
  }

}
