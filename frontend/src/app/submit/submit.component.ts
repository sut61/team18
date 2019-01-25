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
  
  datalend:any={maidId:"",customerId:"",cleaningId:"",electricId:"",lendData:""};

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

    this.lend.getElectricId().subscribe(data=>{
      console.log(data)
      this.electric = data;
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

  electric: Array<any>= [];
  electrics: any = {
    electric:null
  };
  OnSubmit(){
    console.log(this.datalend)
    this.lend.saveLendEquipment(this.datalend).subscribe(data=>{
      console.log(data)
      this.datalend ={maidId:"",customerId:"",cleaningId:"",electricId:"",lendData:""}
      const dialogRef = this.dialog.open(TextComponent, {
        width: '600px',
    
        data: {name: 'บันทึกสำเร็จ'}
      });
      dialogRef.afterClosed().subscribe(result => {
        console.log('The dialog was closed');
      });
      this.router.navigate(['/mainMaid']);
  
    })
  };
  lode(){
    this.router.navigate(['/mainMaid']);

  };

}

