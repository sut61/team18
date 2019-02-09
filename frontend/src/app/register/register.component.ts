import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { RegisterService } from '../service/register.service';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  views: any = {
    titlenameId: "",
    nametInput: "",
    phoneInput: "",
    emailInput: "",
    addressInput: "",
    districtInput: "",
    cantonInput: "",
    provinceInput: "",
    typeworkingSelect: "",
    typeworkingDateSelect: "",
    companySelect: '',
    WelsaSelect: ""
  };
  constructor(private registerService: RegisterService, private httpClient: HttpClient, private route: ActivatedRoute, private router: Router) { }
  ngOnInit() {
    this.registerService.getTitlenameType().subscribe(data => {
      console.log(data)
      this.titlenameType = data;
    })

    this.registerService.getTypeworking().subscribe(data => {
      console.log(data)
      this.typeworking = data;
    })

    this.registerService.getTypeworkingDate().subscribe(data => {
      console.log(data)
      this.typeworkingDate = data;
    })
    this.registerService.getCompanyForMaid().subscribe(data => {
      console.log(data)
      this.companyId = data;
    })
    this.registerService.getWelsaName().subscribe(data => {
      console.log(data)
      this.welsa = data;
    })
  }

  titlenameType: Array<any> = [];
  titlenameTypes: any = {
    titlenameType: null
  };

  typeworking: Array<any> = [];
  typeworkings: any = {
    typeworking: null
  };

  typeworkingDate: Array<any> = [];
  typeworkingDates: any = {
    typeworkingDate: null
  };

  companyId: Array<any> = [];
  companyIds: any = {
    companyId: null
  };

  welsa: Array<any> = [];
  welsas: any = {
    welsa: null
  };

  save_func() {
    this.httpClient.get('http://localhost:8080/regi/' + this.views.titlenameId + '/' + this.views.nametInput
      + '/' + this.views.phoneInput + '/' + this.views.emailInput + '/' + this.views.addressInput + '/'
      + this.views.districtInput + '/' + this.views.cantonInput + '/' + this.views.provinceInput + '/'
      + this.views.typeworkingSelect + '/' + this.views.typeworkingDateSelect + '/' + this.views.companySelect + '/'
      + this.views.WelsaSelect, this.views).subscribe(
        data => {
          alert("บันทึกสำเสร็จ");
          this.router.navigate(['/loginMaid']);
        })

  }

  Canceled() {
    this.router.navigate(['/loginMaid']);
  }

}
