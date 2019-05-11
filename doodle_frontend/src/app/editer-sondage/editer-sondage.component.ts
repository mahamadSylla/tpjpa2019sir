import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { SondageService } from '../services/sondage-service';

@Component({
  selector: 'app-editer-sondage',
  templateUrl: './editer-sondage.component.html',
  styleUrls: ['./editer-sondage.component.css']
})
export class EditerSondageComponent implements OnInit {

  sondage;
  constructor(private route: ActivatedRoute, private router: Router, private sondageService: SondageService) { 
    let id = this.route.snapshot.paramMap.get('id');
    this.sondageService.getSondageById(id).subscribe((mySurvey)=>{
      this.sondage = mySurvey;
    });
  }

  put(){
    this.sondageService.putSurvey(this.sondage).subscribe((newSurvey: any)=>{
      this.router.navigateByUrl('sondages');
    });
  }

  ngOnInit() {
  }

}
