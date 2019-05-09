import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-creation-user',
  templateUrl: './creation-user.component.html',
  styleUrls: ['./creation-user.component.css']
})
export class CreationUserComponent implements OnInit {
@Input('utilisateur') utilisateur;
  constructor() { }

  ngOnInit() {
  }

}
