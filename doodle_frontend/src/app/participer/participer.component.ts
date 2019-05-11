import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { SondageService } from '../services/sondage-service';

@Component({
  selector: 'app-participer',
  templateUrl: './participer.component.html',
  styleUrls: ['./participer.component.css']
})
export class ParticiperComponent implements OnInit {

  datesProposees;
  id;
  reponse= {
    idSondage: this.id,
    idUtilisateur:1,
    choixDates: []
  }
  choixDates = [];
   addChoose(event, d){
     console.log(event.target.checked);
     
     if(event.target.checked){
      this.choixDates.push(d)
     }else{
       var del:number = this.removeChoose(this.choixDates, d)
      this.choixDates.splice(del, 1);
     }
   }

   removeChoose(c:any[], d){
    for(var i:number=0; i < c.length; i++){
      if (c[i] == d) {
        return i;
      }
    }
   }
  constructor(private route: ActivatedRoute, private router: Router, private sondageServie: SondageService) { 
    let id = this.route.snapshot.paramMap.get('id');
    this.sondageServie.getTimeSlotsByIdSondage(id).subscribe((myDates)=>{
      this.datesProposees = myDates;
    })
  }

  put(){
    this.sondageServie.participerAuSondage(this.reponse).subscribe((MyResponse : any) =>{
      this.router.navigateByUrl('utilisateurs');
    });
  }
  ngOnInit() {
  }

}
