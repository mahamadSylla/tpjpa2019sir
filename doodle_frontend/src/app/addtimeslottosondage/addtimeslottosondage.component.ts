import { Component, OnInit, Input } from '@angular/core';
import { SondageService } from '../services/sondage-service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-addtimeslottosondage',
  templateUrl: './addtimeslottosondage.component.html',
  styleUrls: ['./addtimeslottosondage.component.css']
})
export class AddtimeslottosondageComponent implements OnInit {
  @Input("timeSlot") timeSlot;


  constructor(private sondageService: SondageService, private route: ActivatedRoute) { }

  ngOnInit() {
  }

}
