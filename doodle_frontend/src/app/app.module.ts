import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import { BsDropdownModule } from 'ngx-bootstrap/dropdown';
import { MDBBootstrapModule } from 'angular-bootstrap-md';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { NavigationComponent } from './navigation/navigation.component';
import { ParticiperComponent } from './participer/participer.component';
import { SondageComponent } from './sondage/sondage.component';
import { ReunionComponent } from './reunion/reunion.component';
import { InscriptionComponent } from './inscription/inscription.component';
import { EditerComponent } from './editer/editer.component';
import { ParticipantsComponent } from './participants/participants.component';
import { CreersondageComponent } from './creersondage/creersondage.component';
import { CreerdatessondagesComponent } from './creerdatessondages/creerdatessondages.component';
import { ConsultersondageComponent } from './consultersondage/consultersondage.component';
import { HttpClientModule} from '@angular/common/http';
import { UtilisateurComponent } from './utilisateur/utilisateur.component';
import { AlergiesComponent } from './alergies/alergies.component';
import { RoleComponent } from './role/role.component';
import { SondagecreeComponent } from './sondagecree/sondagecree.component';
import { ReunionmanqueesComponent } from './reunionmanquees/reunionmanquees.component';
import { ReunionassisteesComponent } from './reunionassistees/reunionassistees.component';
import { ConsultereunionComponent } from './consultereunion/consultereunion.component';


@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    NavigationComponent,
    ParticiperComponent,
    SondageComponent,
    ReunionComponent,
    InscriptionComponent,
    EditerComponent,
    ParticipantsComponent,
    CreersondageComponent,
    CreerdatessondagesComponent,
    ConsultersondageComponent,
    UtilisateurComponent,
    AlergiesComponent,
    RoleComponent,
    SondagecreeComponent,
    ReunionmanqueesComponent,
    ReunionassisteesComponent,
    ConsultereunionComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    BsDropdownModule.forRoot(),
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
