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
    name:'',
    firstName:'',
    mail:'',
    password:''
  }
   state = false;
  constructor(private route: Router, private serviceUtilisateur : UtilisateurService) { }

  put(){
    this.serviceUtilisateur.putUser(this.utilisateur).subscribe((myUser : any) => { this.utilisateur = myUser;
      this.state = true;
      console.log(JSON.stringify(this.utilisateur));
    });

  }
  ngOnInit() {
  }

}
