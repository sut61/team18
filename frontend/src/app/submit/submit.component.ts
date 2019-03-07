import { Component, OnInit } from '@angular/core';
import {LendService} from '../service/lend.service';
import {TextComponent} from '../text/text.component';
import { MatDialog } from '@angular/material';
import { Router, ActivatedRoute } from '@angular/router';


@Component({
  selector: 'app-submit',
  templateUrl: './submit.component.html',
  styleUrls: ['./submit.component.css']
})
export class SubmitComponent implements OnInit {
  
  datalend:any={maidId:null,customerId:null,cleaningId:null,lendData:null,lendstart:null,lendend:null};

  constructor(private lend : LendService ,public dialog: MatDialog,private route: ActivatedRoute,
    private router: Router) {

   }

   ngOnInit() {

    this.lend.getMaidId().subscribe(data=>{
      console.log(data)
      this.maidName = data;
    })

    this.lend.getCustomerId().subscribe(data=>{
      console.log(data)
      this.customerName = data;
    })
    this.lend.getCleaningId().subscribe(data=>{
      console.log(data)
      this.cleaning = data;
    })

   
  }

  maidName: Array<any>= [];
  maidNames: any = {
    maidName:null
  };
  
  customerName: Array<any>= [];
  customerNames: any = {
    customerName:null
  };
  
  cleaning: Array<any>= [];
  cleanings: any = {
    cleaning:null
  };

  OnSubmit(){
    if(this.datalend.maidId == null){
      alert("กรุณาเลือกแม่บ้าน");
    }
    else if(this.datalend.customerId == null){
      alert("กรุณาเลือกลูกค้า");
    }
    else if(this.datalend.cleaningId == null){
      alert("กรุณาเลือกอุปกรณ์ทำความสะอาด");
    }
    else if(this.datalend.lendstart == null){
      alert("กรุณาเลือกวันที่ยืม");
    }
    else if(this.datalend.lendend == null){
      alert("กรุณาเลือกวันที่คืน");
    }
    else{
    console.log(this.datalend)
    this.lend.saveLendEquipment(this.datalend).subscribe(data=>{
      console.log(data)
      this.datalend ={maidId:"",customerId:"",cleaningId:"",lendData:"",lendstart:"",lendend:""}
      alert('บันทึกสำเร็จ');
      
      this.router.navigate(['/mainMaid']);
  
    },
    error => {
      console.log('Error', error);
      alert('เกิด Error');
    })

    }
  };
  lode(){
    this.router.navigate(['/mainMaid']);

  };

}

