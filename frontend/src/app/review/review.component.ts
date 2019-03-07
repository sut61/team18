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
  datareview:any={maidId:null,scoreId:null,typereviewId:null,review:null,adjust:null};

  displayedColumns: string[] = ['no', 'maidName','typereview','score','comment','adjust'];

  selection = new SelectionModel<ReviewCalum>(true, []);
  allReview: Array<any>;
  private id: number;
  private sub: any;
  private inputEmail: any;

  constructor(private rev : ReviewService,private route: ActivatedRoute,private router: Router) { 
    this.inputEmail = this.route.snapshot.paramMap.get('inputEmail');
  }

  ngOnInit() {
    this.rev.getReview().subscribe(data => {
      this.allReview = data;
      console.log(this.allReview);
    });

    this.rev.getMaidId().subscribe(data=>{
      console.log(data)
      this.maidName = data;
    });
    
    this.rev.getScoreId().subscribe(data=>{
      console.log(data)
      this.score = data;
    });
    this.rev.getTypereviewId().subscribe(data=>{
      console.log(data)
      this.typereview = data;
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
  typereview: Array<any>= [];
  typereviews: any = {
    typereview:null
  };
  

  ss(){


    if(this.datareview.maidId == null){
      alert("กรุณาเลือกแม่บ้าน");
    }
    else if(this.datareview.typereviewId == null){
      alert("กรุณาเลือกประเภทการรีวิว");
    }
    else if(this.datareview.scoreId == null){
      alert("กรุณาให้คะแนนการรีวิว");
    }
    else if(this.datareview.review == null){
      alert("กรุณาใส่ความคิดเห็น");
    }
    else if(this.datareview.adjust == null){
      alert("กรุณาใส่สิ่งที่ควรปรับปรุง");
    }
    else{
    console.log(this.datareview)
    this.rev.saveReview(this.datareview).subscribe(data=>{
      console.log(data)
      this.datareview ={maidId:"",scoreId:"",typereviewId:"",review:"",adjust:""}
      alert("บันทึกสำเสร็จ");
      
    },
    error => {
      console.log('Error', error);
      alert('เกิด Error');
    })
    }
  };
  cs(){
    this.router.navigate(['/mainCus', this.inputEmail]);
  };
  

}
