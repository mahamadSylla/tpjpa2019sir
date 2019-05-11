import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})

export class SondageService {

  url: string = 'api/sondages';
  headers = new HttpHeaders({ 'Content-Type': 'application/json' });

  constructor(private http: HttpClient) { }

  getAll() {
    return this.http.get(this.url);
  }

  getAllPlages() {
    return this.http.get(this.url + '/' + 'allPlages');
  }

  putSurvey(sondage) {
    return this.http.put(this.url + '/' + 'update', sondage, { headers: this.headers });
  }

  deleteSondage(id: string) {
    return this.http.delete(this.url + '/' + id + '/'+'delete');
  }
  getSondageById(id: string) {
    return this.http.get(this.url + '/' + id);
  }

  getReunionByIdSondage(id: string) {
    return this.http.get(this.url + '/' + id + '/' + 'reunion');
  }

  getParticipantsByIdSondage(id: string) {
    return this.http.get(this.url + '/' + id + '/' + 'participants');
  }
  getTimeSlot(id: string) {
    return this.http.get(this.url + '/' + 'choixDate' + '/' + id);
  }

  getTimeSlotsByIdSondage(id: string){
    return this.http.get(this.url  + '/' + id + '/' + 'datesProposees');
  }

  creerPlage(plage) {
    return this.http.post(this.url + '/' + 'creerPlageHoraire', plage, { headers: this.headers });
  }

  creerSondage(id, sondage) {
    return this.http.post(this.url + '/' + id + '/' + 'creer', sondage, { headers: this.headers });
  }

  participerAuSondage(reponse){
    return this.http.put(this.url + '/' + 'mesReponses', reponse, { headers: this.headers });
  }
}
