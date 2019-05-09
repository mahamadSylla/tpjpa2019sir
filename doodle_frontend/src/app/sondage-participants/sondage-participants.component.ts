import { Component, OnInit, Input } from '@angular/core';
//import { ParticipantsComponent } from '../participants/participants.component';

@Component({
  selector: 'app-sondage-participants',
  templateUrl: './sondage-participants.component.html',
  styleUrls: ['./sondage-participants.component.css']
})
export class SondageParticipantsComponent implements OnInit {
 @Input("participants") participants;
  constructor() { }

  ngOnInit() {
  }

}
