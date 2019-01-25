import { Component, OnInit } from '@angular/core';
import { HttpClient} from '@angular/common/http';
import { RegisterService } from '../service/register.service';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  views: any = {nametInput: "",
  addressInput: "",
  emailInput: "",
  phoneInput: "",
  provinceInput: "",
  districtInput: "",
  cantonInput: "",
  titlenameId: "",
  typeworkingSelect:"",
 typeworkingDateSelect: ""
  };
  constructor(private registerService: RegisterService , private httpClient: HttpClient, private route: ActivatedRoute,private router: Router) { }
  ngOnInit() {
    this.registerService.getTitlenameType().subscribe(data=>{
      console.log(data)
      this.titlenameType = data;
    })

    this.registerService.getTypeworking().subscribe(data=>{
      console.log(data)
      this.typeworking = data;
    })

    this.registerService.getTypeworkingDate().subscribe(data=>{
      console.log(data)
      this.typeworkingDate = data;
    })

  }

  titlenameType: Array<any>= [];
  titlenameTypes: any = {
    titlenameType:null
  };

  typeworking: Array<any>= [];
  typeworkings: any = {
    typeworking:null
  };

  typeworkingDate: Array<any>= [];
  typeworkingDates: any = {
    typeworkingDate:null
  };

  save_func(){
    console.log(this.views)
    this.registerService.saveRegi(this.views).subscribe(data=>{
      console.log(data)
      this.views ={nametInput: "",
        addressInput: "",
        emailInput: "",
        phoneInput: "",
        provinceInput: "",
        districtInput: "",
        cantonInput: "",
        titlenameId: "",
        typeworkingSelect:"",
       typeworkingDateSelect: ""
        
      };
      alert("บันทึกสำเสร็จ");
    this.router.navigate(['/loginMaid']); 
    })
       
  }
   Canceled(){
      this.router.navigate(['/loginMaid']); 
    }    
  
}
