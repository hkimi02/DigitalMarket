import { NumberInput } from '@angular/cdk/coercion';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-accueil-client',
  templateUrl: './accueil-client.component.html',
  styleUrls: ['./accueil-client.component.scss']
})
export class AccueilClientComponent implements OnInit {
  categorieId:String | null=null;
  constructor(private route : ActivatedRoute){}
  ngOnInit(){
     this.categorieId  = this.route.snapshot.paramMap.get('id');
  }
}
