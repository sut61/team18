import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { RegisterService } from '../service/register.service';
import { Router, ActivatedRoute } from '@angular/router';
@Component({
  selector: 'app-login-maid',
  templateUrl: './login-maid.component.html',
  styleUrls: ['./login-maid.component.css']
})
export class LoginMaidComponent implements OnInit {
  maids: any;
  hide = true;
  select: any = {
    adminUsername: null,
    adminPassword: null
  }
  constructor(private route: ActivatedRoute,private registerService: RegisterService, private httpClient: HttpClient, private router: Router) { }

  ngOnInit() {
  }
  loadAdminData(){
    console.log(this.select.adminUsername);
    this.registerService.getMaidZZZ(this.select.adminUsername).subscribe(data => {
      this.maids = data;
      console.log(this.maids);
    });
  }
  login(){
    if(this.select.adminUsername == null || this.select.adminUsername == ''){
      alert('Please Enter Username');
    }else if(this.select.adminPassword == null || this.select.adminPassword == ''){
      alert('Please Enter Password');
    }else{
      if(this.select.adminUsername == this.maids.maidEmail){
        if(this.select.adminPassword == this.maids.maidPhone){
          alert('เข้าสู่ระบบสำเร็จ');
          this.router.navigate(['/mainMaid']);
        }else{
          alert('รหัสผ่านไม่ถูกต้อง');
        }
      }else{
        alert('ไม่พบบัญชีผู้ใช้');
      }
    }
  }

  register(){
    this.router.navigate(['/register']);
  }

}
