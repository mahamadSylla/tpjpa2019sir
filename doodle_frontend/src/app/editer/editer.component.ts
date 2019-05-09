import { Component, OnInit } from '@angular/core';

import { ActivatedRoute, Route, Router } from '@angular/router';
import { UtilisateurService } from '../services/utilisateur-service';

@Component({
  selector: 'app-editer',
  templateUrl: './editer.component.html',
  styleUrls: ['./editer.component.css']
})
export class EditerComponent implements OnInit {
  user = {};
  
  constructor(private route: ActivatedRoute, private utilisateurService: UtilisateurService, private router: Router) {
    let id = route.snapshot.paramMap.get('id');
    utilisateurService.getUtilisateurById(id).subscribe((monutilisateur)=> {
      this.user = monutilisateur;
      console.log(JSON.stringify(this.user))
      });
  }

  put(){
    this.utilisateurService.putUser(this.user).subscribe((newUser : any) => { 
      this.router.navigateByUrl('utilisateurs');
    }); 
  }
  ngOnInit() {
  }

}
