import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { AdminService } from '../service/admin.service';
import { Router, ActivatedRoute } from '@angular/router';
@Component({
  selector: 'app-login-addmin',
  templateUrl: './login-addmin.component.html',
  styleUrls: ['./login-addmin.component.css']
})
export class LoginAddminComponent implements OnInit {
  admin: any;
  hide = true;
  select: any = {
    adminUsername: null,
    adminPassword: null
  }
  constructor(private route: ActivatedRoute,private adminService: AdminService, private httpClient: HttpClient, private router: Router) { }

  ngOnInit() {
  }

  loadAdminData(){
    this.adminService.getAdminAccount(this.select.adminUsername).subscribe(data => {
      this.admin = data;
      console.log(this.admin);
    });
  }
  login(){
    if(this.select.adminUsername == null || this.select.adminUsername == ''){
      alert('Please Enter Username');
    }else if(this.select.adminPassword == null || this.select.adminPassword == ''){
      alert('Please Enter Password');
    }else{
      if(this.select.adminUsername == this.admin.adminUsername){
        if(this.select.adminPassword == this.admin.adminPassword){
          alert('เข้าสู่ระบบสำเร็จ');
          this.router.navigate(['/mainAdmin']);
        }else{
          alert('รหัสผ่านไม่ถูกต้อง');
        }
      }else{
        alert('ไม่พบบัญชีผู้ใช้');
      }
    }
  }
}
