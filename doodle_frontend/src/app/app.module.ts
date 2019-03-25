import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
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
    ParticipantsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
