import { Component, OnInit } from '@angular/core';
import { SondageService } from '../services/sondage-service';
import { ActivatedRoute, Router } from '@angular/router';
import { PlagesComponent } from '../plages/plages.component';

@Component({
  selector: 'app-creerdatessondages',
  templateUrl: './creerdatessondages.component.html',
  styleUrls: ['./creerdatessondages.component.css']
})
export class CreerdatessondagesComponent implements OnInit {

  plage = {
    myDate:'',
    debut: 0,
    fin: 0
  }
  constructor(private serviceSondage: SondageService, private route: Router) { }

  put(){
    this.serviceSondage.creerPlage(this.plage).subscribe((plageHoraire : any) => { 
      this.route.navigateByUrl('plagesHoraire')
      console.log(JSON.stringify(this.plage));
    });
  }

  ngOnInit() {
  }

}
