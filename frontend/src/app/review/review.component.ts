import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import {ReviewService} from '../service/review.service';
import { SelectionModel } from '@angular/cdk/collections';
export interface ReviewCalum {
}

@Component({
  selector: 'app-review',
  templateUrl: './review.component.html',
  styleUrls: ['./review.component.css']
})
export class ReviewComponent implements OnInit {
  datareview:any={maidId:null,scoreId:null,scoreExId:null,scorePerId:null,scoreTiId:null,review:null};

  displayedColumns: string[] = ['no', 'maidName', 'scoreti','scoreex','scorepe','score', 'comment'];
  selection = new SelectionModel<ReviewCalum>(true, []);
  allReview: Array<any>;
  private id: number;
  private sub: any;

  constructor(private rev : ReviewService,private route: ActivatedRoute,private router: Router) { }

  ngOnInit() {
    this.rev.getReview().subscribe(data => {
      this.allReview = data;
      console.log(this.allReview);
    });

    this.rev.getMaidId().subscribe(data=>{
      console.log(data)
      this.maidName = data;
    });
    this.rev.getScoreExId().subscribe(data=>{
      console.log(data)
      this.scoreEx = data;
    });
    this.rev.getScorePerId().subscribe(data=>{
      console.log(data)
      this.scorePer = data;
    });
    this.rev.getScoreTiId().subscribe(data=>{
      console.log(data)
      this.scoreTi = data;
    });
    this.rev.getScoreId().subscribe(data=>{
      console.log(data)
      this.score = data;
    });
  }
  maidName: Array<any>= [];
  maidNames: any = {
    maidName:null
  };
  score: Array<any>= [];
  scores: any = {
    score:null
  };
  scoreEx: Array<any>= [];
  scoreExs: any = {
    scoreEx:null
  };
  scorePer: Array<any>= [];
  scorePers: any = {
    scorePer:null
  };
  scoreTi: Array<any>= [];
  scoreTis: any = {
    scoreTi:null
  };

  ss(){


    if(this.datareview.maidId == null){
      alert("กรุณาเลือกแม่บ้าน");
    }
    else if(this.datareview.scoreId == null){
      alert("กรุณาให้คะแนน");
    }
    
    else{
    console.log(this.datareview)
    this.rev.saveReview(this.datareview).subscribe(data=>{
      console.log(data)
      this.datareview ={maidId:"",scoreId:"",scoreExId:"",scorePerId:"",scoreTiId:"",review:""}
      alert("บันทึกสำเสร็จ");
      
    },
    error => {
      console.log('Error', error);
      alert('เกิด Error');
    })
    }
  };
  cs(){
    this.router.navigate(['/mainCus']);
  };
  

}
