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
  maidEmail: "",
  dateInput: "",
  workingdayInput: "",
  mainjobInput: "",
  secondaryjobInput: "",
  placeInput: "",
  maidselect: "",
  typeworkingSelect:"",
  typeworkingDateSelect: "",
  companySelect: ""
};
constructor(private maidSelectService: SelectService , private httpClient: HttpClient, private route: ActivatedRoute,private router: Router) { 
  this.views.maidEmail = this.route.snapshot.paramMap.get('inputEmail');
  console.log(this.views.maidEmail);
}
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
        this.views.maidEmail + '/' +
        this.views.companySelect + '/' + 
        this.views.maidselect + '/' +
        this.views.typeworkingSelect + '/' +
        this.views.typeworkingDateSelect + '/' +
        this.views.dateInput + '/' +
        this.views.workingdayInput + '/' +
        this.views.mainjobInput + '/' +
        this.views.secondaryjobInput + '/' +
        this.views.placeInput , this.views )
               .subscribe(
                   data => {
                     
                       console.log('POST Request is successful', data);
                       alert("Successfully!!");
                       location.reload();
                   },
                   error => {
                   
                        console.log('Rrror', error);
                        alert("ข้อมูลไม่ถูกต้องบันทึกไม่สำเร็จ !!");
                  }

               );
               
  }

  Canceled(){
    this.router.navigate(['/mainCus', this.views.maidEmail]); 
  } 
}



