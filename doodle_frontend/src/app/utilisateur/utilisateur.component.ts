import { Component, OnInit } from '@angular/core';
import { UtilisateurService } from '../services/utilisateur-service';
import { Router } from '@angular/router';
import { ActivatedRoute } from '@angular/router';

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

  //mes variables de test
  al: boolean;
  ro: boolean;
  ra: boolean;
  rm: boolean;
  sc: boolean;
  constructor(private utilisateurService: UtilisateurService, private router: Router, private activaTedRouter: ActivatedRoute) {
  }
  allUsers() {
    this.utilisateurService.getAll().subscribe((resultat) => {
      this.utilisateurs = resultat;
    });
  }
  ngOnInit() {
    this.allUsers();
  }
  onGetAlergie(id: string) {
    this.utilisateurService.getAlergies(id).subscribe(myAlergeis => {
      this.alergies = myAlergeis;
      this.al = true;
      this.ro = false;
      this.ra = false;
      this.rm = false;
      this.sc = false;


      console.log(JSON.stringify(myAlergeis));
    });
  }
  onGetRole(id: string) {
    this.utilisateurService.getRole(id).subscribe(myRole => {
      this.roles = myRole;
      this.al = false;
      this.ro = true;
      this.ra = false;
      this.rm = false;
      this.sc = false;
      console.log(JSON.stringify(myRole));
    });
  }
  onGetReunionManquees(id: string) {
    this.utilisateurService.getReunionManquee(id).subscribe(MyLosedMeeting => {
      this.reunionManquees = MyLosedMeeting;

      this.al = false;
      this.ro = false;
      this.ra = false;
      this.rm = true;
      this.sc = false;
      console.log(JSON.stringify(MyLosedMeeting));
    });
  }
  onGetReunionAssistees(id: string) {
    this.utilisateurService.getReunionAssistee(id).subscribe(MyMeeting => {
      this.reunionAssistees = MyMeeting;

      this.al = false;
      this.ro = false;
      this.ra = true;
      this.rm = false;
      this.sc = false;
      console.log(JSON.stringify(MyMeeting));
    });
  }
  onGetSondage(id: string) {
    this.utilisateurService.getSondage(id).subscribe(mySurvey => {
      this.sondageCree = mySurvey;

      this.al = false;
      this.ro = false;
      this.ra = false;
      this.rm = false;
      this.sc = true;
      console.log(JSON.stringify(mySurvey));
    });
  }
  delete(id: string) {
    this.utilisateurService.deleteUser(id).subscribe((newUser: any) => {
      this.allUsers();
    });
  }

}
