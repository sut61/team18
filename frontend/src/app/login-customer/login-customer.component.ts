import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { CustomerService } from '../service/customer.service';
import { Router, ActivatedRoute } from '@angular/router';
@Component({
  selector: 'app-login-customer',
  templateUrl: './login-customer.component.html',
  styleUrls: ['./login-customer.component.css']
})
export class LoginCustomerComponent implements OnInit {
  cus: any;
  hide = true;
  select: any = {
    customerEmail: null,
    customerpass: null
  }
  constructor(private route: ActivatedRoute,private customerService: CustomerService, private httpClient: HttpClient, private router: Router) { }

  ngOnInit() {
  }
  loadCustomerData(){
    this.customerService.getCustomerAccount(this.select.customerEmail).subscribe(data => {
      this.cus = data;
      console.log(this.cus);
    });
  }
  login(){
    if(this.select.customerEmail == null || this.select.customerEmail == ''){
      alert('Please Enter Username');
    }else if(this.select.customerpass == null || this.select.customerpass == ''){
      alert('Please Enter Password');
    }else{
      if(this.select.customerEmail == this.cus.customerEmail){
        if(this.select.customerpass == this.cus.customerpass){
          alert('เข้าสู่ระบบสำเร็จ');
          this.router.navigate(['/mainCus']);
        }else{
          alert('รหัสผ่านไม่ถูกต้อง');
        }
      }else{
        alert('ไม่พบบัญชีผู้ใช้');
      }
    }
  }

}
