import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ReunionService {
  url: string = 'api/reunions';
  constructor(private http: HttpClient) { }
  getAll() {
    return this.http.get(this.url);
  }
  getReunionById(id: string) {
    return this.http.get(this.url + '/' + id);
  }
}
