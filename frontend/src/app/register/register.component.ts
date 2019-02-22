import {Component, OnInit} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {RegisterService} from '../service/register.service';
import {Router, ActivatedRoute} from '@angular/router';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  titlenameType: Array<any>;
  typeworking: Array<any>;
  typeworkingDate: Array<any>;
  companyId: Array<any>;
  welsa: Array<any>;
  views: any = {
    titlenameId: '',
    nametInput: '',
    phoneInput: '',
    emailInput: '',
    addressInput: '',
    districtInput: '',
    cantonInput: '',
    provinceInput: '',
    typeworkingSelect: '',
    typeworkingDateSelect: '',
    companySelect: '',
    WelsaSelect: ''
  };

  constructor(private registerService: RegisterService, private httpClient: HttpClient, private route: ActivatedRoute,
              private router: Router) {
  }

  ngOnInit() {
    this.registerService.getTitlenameType().subscribe(data => {
      console.log(data);
      this.titlenameType = data;
    });

    this.registerService.getTypeworking().subscribe(data => {
      console.log(data);
      this.typeworking = data;
    });

    this.registerService.getTypeworkingDate().subscribe(data => {
      console.log(data);
      this.typeworkingDate = data;
    });
    this.registerService.getCompanyForMaid().subscribe(data => {
      console.log(data);
      this.companyId = data;
    });

  }

  dataChange() {
    this.registerService.getWelsaName(this.views.companySelect, this.views.typeworkingDateSelect).subscribe(data => {
      console.log(data);
      this.welsa = data;
    });
  }
  save_func() {
    this.httpClient.post('http://localhost:8080/regi/' + this.views.titlenameId + '/' + this.views.nametInput
      + '/' + this.views.phoneInput + '/' + this.views.emailInput + '/' + this.views.addressInput + '/'
      + this.views.districtInput + '/' + this.views.cantonInput + '/' + this.views.provinceInput + '/'
      + this.views.typeworkingSelect + '/' + this.views.typeworkingDateSelect + '/' + this.views.companySelect + '/'
      + this.views.WelsaSelect, this.views).subscribe(
      data => {
        alert('บันทึกสำเสร็จ');
        this.router.navigate(['/loginMaid']);
      });

  }

  Canceled() {
    this.router.navigate(['/loginMaid']);
  }

}
