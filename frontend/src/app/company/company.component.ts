import { Component, OnInit } from '@angular/core';
import { CompanyService } from '../service/company.service';
import { HttpClient } from '@angular/common/http';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-company',
  templateUrl: './company.component.html',
  styleUrls: ['./company.component.css']
})
export class CompanyComponent implements OnInit {
  companytype: Array<any>;
  provincename: Array<any>;
  views: any = {
    name: null,
    type: null,
    phone: null,
    address: null,
    province: null
  }
  constructor(private route: ActivatedRoute, private customerService: CompanyService, private httpClient: HttpClient, private router: Router) { }

  ngOnInit() {
    this.customerService.getCompanytype().subscribe(data => {
      this.companytype = data;
      console.log(this.companytype);
    })
    this.customerService.getProvince().subscribe(data => {
      this.provincename = data;
      console.log(this.provincename);
    })
  }
  save_func() {
    if (this.views.name == null || this.views.name == '') {
      alert('กรุณาระบุชื่อบริษัท');
    }
    else if (this.views.type == null) {
      alert('กรุณาเลือกประเภทบริษัท');
    }
    else if (this.views.phone == null || this.views.phone == '') {
      alert('กรุณาระบุที่เบอร์โทรศัพท์');
    }
    else if (this.views.address == null || this.views.address == '') {
      alert('กรุณาระบุที่อยู่บริษัท');
    }
    else if (this.views.province == null) {
      alert('กรุณาเลือกจังหวัด');
    } else {
      console.log(this.views.name);
      console.log(this.views.type);
      console.log(this.views.phone);
      console.log(this.views.address);
      console.log(this.views.province);
      this.httpClient.post('http://localhost:8080/company/' + this.views.name + '/' + this.views.type + '/' + this.views.phone + '/' + this.views.address + '/' + this.views.province, this.views)
        .subscribe(
          data => {
            console.log('PUT Request is successful', data);
            alert("บันทึกสำเร็จ !!");
            this.router.navigate(['/mainAdmin']);
          },
          error => {
            console.log('Rrror', error);
            alert("ข้อมูลไม่ถูกต้องบันทึกไม่สำเร็จ");
          }
        );
    }


  }
}
