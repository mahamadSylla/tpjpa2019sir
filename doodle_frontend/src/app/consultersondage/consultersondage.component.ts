import { Component, OnInit } from '@angular/core';
import {ActivatedRoute} from '@angular/router';
import {SondageService} from '../services/sondage-service';

@Component({
  selector: 'app-consultersondage',
  templateUrl: './consultersondage.component.html',
  styleUrls: ['./consultersondage.component.css']
})
export class ConsultersondageComponent implements OnInit {
  sondage;
  reunion;
  r: boolean;
  participants;
  p: boolean;
  constructor(private route: ActivatedRoute, private sondageService: SondageService) {
    let id = route.snapshot.paramMap.get('id');
    sondageService.getSondageById(id).subscribe((monSondage) => this.sondage = monSondage);
  }

  onGetMeeting(id: string) {
    this.sondageService.getReunionByIdSondage(id).subscribe(myMeeting => {
      this.reunion = myMeeting;
      this.r = true;
      this.p = false;

      console.log(JSON.stringify(myMeeting));
    })
  }
  onGetParticipant(id: string) {
    this.sondageService.getParticipantsByIdSondage(id).subscribe(myParticipant => {
      this.participants = myParticipant;
      this.r = false;
      this.p = true;

      console.log(JSON.stringify(myParticipant));
    })
  }
  ngOnInit() {
  }

}
