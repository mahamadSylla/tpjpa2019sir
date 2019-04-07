import {Component, Input, OnInit} from '@angular/core';

@Component({
  selector: 'app-reunionassistees',
  templateUrl: './reunionassistees.component.html',
  styleUrls: ['./reunionassistees.component.css']
})
export class ReunionassisteesComponent implements OnInit {
  @Input("reunionAssistees") reunionAssistees;
  constructor() { }

  ngOnInit() {
  }

}
