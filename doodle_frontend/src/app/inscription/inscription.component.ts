import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UtilisateurService } from '../services/utilisateur-service';

@Component({
  selector: 'app-inscription',
  templateUrl: './inscription.component.html',
  styleUrls: ['./inscription.component.css']
})
export class InscriptionComponent implements OnInit {
  utilisateur = { 
    name:'a',
    firstName:'b',
    mail:'c',
    password:'d'
  }
  constructor(private route: Router, private serviceUtilisateur : UtilisateurService) { }

  put(){
    this.serviceUtilisateur.putUser(this.utilisateur).subscribe((myUser : any) => { this.utilisateur = myUser;
      this.route.navigateByUrl('/creationuser');
    });

  }
  ngOnInit() {
  }

}
