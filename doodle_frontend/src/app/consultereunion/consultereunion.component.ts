import { Component, OnInit } from '@angular/core';
import {ActivatedRoute} from '@angular/router';
import {ReunionService} from '../services/reunion.service';

@Component({
  selector: 'app-consultereunion',
  templateUrl: './consultereunion.component.html',
  styleUrls: ['./consultereunion.component.css']
})
export class ConsultereunionComponent implements OnInit {

  reunion;
  constructor(private route: ActivatedRoute, private reunionService: ReunionService) {
    let id = route.snapshot.paramMap.get('id');
    reunionService.getReunionById(id).subscribe((myMeeting) => this.reunion = myMeeting);
  }
  ngOnInit() {
  }

}
