import { Component, OnInit } from '@angular/core';
import { SondageService } from '../services/sondage-service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-creersondage',
  templateUrl: './creersondage.component.html',
  styleUrls: ['./creersondage.component.css']
})
export class CreersondageComponent implements OnInit {

  id = 1;
  sondage = {
    'intitule':'',
    'participatedWebLink':''
  }
  constructor(private sondageService: SondageService, private route: Router) { }

  put(){
    this.sondageService.creerSondage(this.id, this.sondage).subscribe((sondage : any) => { 
      this.route.navigateByUrl('sondages')
      console.log(JSON.stringify(this.sondage));
    });
  }

  ngOnInit() {
  }

}
