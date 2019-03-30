import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})

export class SondageService {

url: string = 'api/sondages';

  constructor(private http: HttpClient) { }

  getAll() {
    return this.http.get(this.url);
  }

  getSondageById(id: string) {
    return this.http.get(this.url + '/' + id);
  }
}
