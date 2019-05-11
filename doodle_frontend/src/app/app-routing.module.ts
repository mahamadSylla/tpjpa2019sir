import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {ConsultersondageComponent} from './consultersondage/consultersondage.component';
import {SondageComponent} from './sondage/sondage.component';
import {UtilisateurComponent} from './utilisateur/utilisateur.component';
import {AlergiesComponent} from './alergies/alergies.component';
import {ReunionComponent} from './reunion/reunion.component';
import {ConsultereunionComponent} from './consultereunion/consultereunion.component';
import { InscriptionComponent } from './inscription/inscription.component';
import { LoginComponent } from './login/login.component';
import { CreationUserComponent } from './creation-user/creation-user.component';
import { SondagecreeComponent } from './sondagecree/sondagecree.component';
import { CreerdatessondagesComponent } from './creerdatessondages/creerdatessondages.component';
import { CreersondageComponent } from './creersondage/creersondage.component';
import { PlagesComponent } from './plages/plages.component';
import { EditerComponent } from './editer/editer.component';
import { EditerSondageComponent } from './editer-sondage/editer-sondage.component';
import { ParticiperComponent } from './participer/participer.component';

const routes: Routes = [
  {
    path : 'sondage/consulter/:id',
    component : ConsultersondageComponent
  },
  {
    path : 'utilisateur/editer/:id',
    component : EditerComponent
  },
  {
    path : 'sondage/editer/:id',
    component : EditerSondageComponent
  },
  {
    path : 'sondages',
    component : SondageComponent
  },
  {
    path : 'sondage/participer/:id',
    component : ParticiperComponent
  },
  {
    path : 'sondage/creer',
    component : CreersondageComponent
  },
  {
    path : 'sondage/plages',
    component :CreerdatessondagesComponent
  },
  {
    path : 'plagesHoraire',
    component :PlagesComponent
  },
  {
    path : 'utilisateurs',
    component : UtilisateurComponent
  },
  {
    path : 'reunion/consulter/:id',
    component : ConsultereunionComponent
  },
  {
    path : 'reunions',
    component : ReunionComponent
  },
  {
    path : 'inscription',
    component : InscriptionComponent
  },
  {
    path : 'login',
    component : LoginComponent
  },
  {
    path : 'creationuser',
    component : CreationUserComponent
  },


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
