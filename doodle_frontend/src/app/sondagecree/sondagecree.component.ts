import {Component, Input, OnInit} from '@angular/core';

@Component({
  selector: 'app-sondagecree',
  templateUrl: './sondagecree.component.html',
  styleUrls: ['./sondagecree.component.css']
})
export class SondagecreeComponent implements OnInit {
  @Input("sondageCree") sondageCree;
  constructor() { }

  ngOnInit() {
  }

}
