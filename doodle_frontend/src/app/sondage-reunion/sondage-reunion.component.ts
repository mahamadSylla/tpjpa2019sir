import { Component, OnInit, Input } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { SondageService } from '../services/sondage-service';

@Component({
  selector: 'app-sondage-reunion',
  templateUrl: './sondage-reunion.component.html',
  styleUrls: ['./sondage-reunion.component.css']
})
export class SondageReunionComponent implements OnInit {
  @Input("reunion") reunion;
  constructor(private route: ActivatedRoute, private sondageService: SondageService) {
  }
  ngOnInit() {
  }

}
