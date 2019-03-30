import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {ConsultersondageComponent} from './consultersondage/consultersondage.component';
import {SondageComponent} from './sondage/sondage.component';

const routes: Routes = [
  {
  path : 'sondage/consulter/:id',
  component : ConsultersondageComponent
  },
  {
    path : 'sondages',
    component : SondageComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
