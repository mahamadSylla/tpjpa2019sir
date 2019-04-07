import {Component, Input, OnInit} from '@angular/core';

@Component({
  selector: 'app-reunionmanquees',
  templateUrl: './reunionmanquees.component.html',
  styleUrls: ['./reunionmanquees.component.css']
})
export class ReunionmanqueesComponent implements OnInit {
  @Input("reunionManquees") reunionManquees;
  constructor() { }

  ngOnInit() {
  }

}
