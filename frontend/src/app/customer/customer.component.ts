import { Component, OnInit } from '@angular/core';
import { CustomerService } from '../service/customer.service';
import { HttpClient} from '@angular/common/http';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-customer',
  templateUrl: './customer.component.html',
  styleUrls: ['./customer.component.css']
})
export class CustomerComponent implements OnInit {
  titleNames: Array<any>;
  customersexs: Array<any>;
  countryCode: Array<any>;
  views: any = {
    titleName: null,
    customerName: null,
    sex: null,
    personal: null,
    email: null,
    pass: null,
    countryCodes: null,
    phone: null,
    address: null
    
  };
  constructor(private route: ActivatedRoute,private customerService: CustomerService , private httpClient: HttpClient,private router: Router) { }

  ngOnInit() {
    this.customerService.getTitlename().subscribe(data => {
      this.titleNames = data;
      console.log(this.titleNames);
    })
    this.customerService.getCountryCode().subscribe(data => {
      this.countryCode = data;
      console.log(this.countryCode);
      })
    this.customerService.getCustomersex().subscribe(data => {
      this.customersexs = data;
      console.log(this.customersexs);
      })
  }
  save_func() {
    if (this.views.titleName == null) {
      alert('กรุณาเลือกคำนำหน้าชื่อ');
    }
    else if (this.views.customerName == null || this.views.customerName == '') {
      alert('กรุณาระบุชื่อ-นามสกุล');
    }
    else if(this.views.sex == null) {
      alert('กรุณาเลือกเพศ');
    }
    else if(this.views.email == null || this.views.email == '') {
      alert('กรุณาระบุอีเมล');
    }
    else if(this.views.personal == null || this.views.personal == '') {
      alert('กรุณากรอกเลขประจำตัวประชาชน');
    }
    else if(this.views.pass == null || this.views.pass == '') {
      alert('กรุณาระบุรหัสผ่าน');
    }
    else if(this.views.countryCodes == null) {
      alert('กรุณาเลือกรหัสประเทศ');
    }
    else if(this.views.phone == null || this.views.phone == '') {
      alert('กรุณาระบุเบอร์โทรศัพท์');
    }
    else if(this.views.address == null || this.views.address == '') {
      alert('กรุณาระบุที่อยู่');
    }else {
      this.httpClient.post('http://localhost:8080/customer/' + this.views.titleName + '/' + this.views.customerName + '/' + this.views.sex+ '/' + '/' + this.views.personal+ '/' + this.views.email+ '/' + this.views.pass+ '/' + this.views.countryCodes+ '/' + this.views.phone+ '/' + this.views.address, this.views)
      .subscribe(
          data => {
              console.log('PUT Request is successful', data);
              alert("บันทึกสำเร็จ !!");
              this.router.navigate(['/loginCus']);
          },
          error => {
               console.log('Rrror', error);
               alert("ข้อมูลไม่ถูกต้องบันทึกไม่สำเร็จ !!");
         }
      );
    }
  }


}
