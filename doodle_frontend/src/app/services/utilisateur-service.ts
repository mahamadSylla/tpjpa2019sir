import {Injectable, Input} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class UtilisateurService {
  url: string = 'api/utilisateurs';
  headers = new HttpHeaders({ 'Content-Type': 'application/json'});
  constructor(private http: HttpClient) { }
  getAll() {
    return this.http.get(this.url);
  }
  getUtilisateurById(id: string) {
    return this.http.get(this.url + '/' + id);
  }
  getAlergies(id: string) {
    return this.http.get(this.url + '/' + id + '/' + 'alergies');
  }
  getRole(id: string) {
    return this.http.get(this.url + '/' + id + '/' + 'roles');
  }
  getRessource(url) {
    return this.http.get(url);
    }

  getReunionAssistee(id: string) {
    return this.http.get(this.url + '/' + id + '/' + 'reunionsAssistees');
  }

  getReunionManquee(id: string) {
    return this.http.get(this.url + '/' + id + '/' + 'reunionsManquees');
  }

  getSondage(id: string) {
    return this.http.get(this.url + '/' + id + '/' + 'sondageParticipes');
  }
   putUser(user){
     return this.http.post(this.url + '/' + 'creer',user, {headers: this.headers});
   }
}
