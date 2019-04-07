import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {ConsultersondageComponent} from './consultersondage/consultersondage.component';
import {SondageComponent} from './sondage/sondage.component';
import {UtilisateurComponent} from './utilisateur/utilisateur.component';
import {AlergiesComponent} from './alergies/alergies.component';
import {ReunionComponent} from './reunion/reunion.component';
import {ConsultereunionComponent} from './consultereunion/consultereunion.component';

const routes: Routes = [
  {
    path : 'sondage/consulter/:id',
    component : ConsultersondageComponent
  },
  {
    path : 'sondages',
    component : SondageComponent
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


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
