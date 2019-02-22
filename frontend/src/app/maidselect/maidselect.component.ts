import { Component, OnInit } from '@angular/core';

import { HttpClient} from '@angular/common/http';
import { SelectService } from '../service/select.service';
import { Router, ActivatedRoute } from '@angular/router';
export interface Select {
}

@Component({
  selector: 'app-maidselect',
  templateUrl: './maidselect.component.html',
  styleUrls: ['./maidselect.component.css']
})
export class MaidselectComponent implements OnInit {

  companys: Array<any>;
  typeworking: Array<any>;
  workingDate: Array<any>;
  statusMaid:Array<any>;
  maids:Array<any>;
  
  views: any = {
  emailInput: "",
  maidselect: "",
  typeworkingSelect:"",
  typeworkingDateSelect: "",
  companySelect: "",
  statusSelect:""
};
constructor(private maidSelectService: SelectService , private httpClient: HttpClient, private route: ActivatedRoute,private router: Router) { }
ngOnInit() {
 
  this.maidSelectService.getTypeworking().subscribe(data=>{
    console.log(data)
    this.typeworking = data;
  })

  this.maidSelectService.getStatus().subscribe(data=>{
    console.log(data)
    this.statusMaid = data;
  })

  this.maidSelectService.getTypeworkingDate().subscribe(data=>{
    console.log(data)
    this.workingDate = data;
  })
  this.maidSelectService.getCompanyForMaid().subscribe(data=>{
    console.log(data)
    this.companys = data;
  })
  this.maidSelectService.getMaid().subscribe(data=>{
    console.log(data)
    this.maids = data;
  })
}
  save_func(){
        this.httpClient.post('http://localhost:8080/select/' +
        this.views.emailInput + '/' +
        this.views.companySelect + '/' + 
        this.views.maidselect + '/' +
        this.views.typeworkingSelect + '/' +
        this.views.typeworkingDateSelect + '/' +
        this.views.statusSelect, this.views )
               .subscribe(
                   data => {
                     
                       console.log('POST Request is successful', data);
                       alert("Successfully!!");
                       this.router.navigate(['/mainCus']); 
                   },
                   error => {
                   
                        console.log('Rrror', error);
                        alert("ข้อมูลไม่ถูกต้องบันทึกไม่สำเร็จ !!");
                        this.router.navigate(['/mainCus']); 
                  }

               );
               
  }


  Canceled(){
    this.router.navigate(['/mainCus']); 
  } 
}



