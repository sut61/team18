import { Component, OnInit } from '@angular/core';
import {AdminService} from '../service/admin.service';
import {HttpClient} from '@angular/common/http';
import {MatSnackBar} from '@angular/material';
@Component({
  selector: 'app-learned',
  templateUrl: './learned.component.html',
  styleUrls: ['./learned.component.css']
})
export class LearnedComponent implements OnInit {
  company: Array<any>;
  skill: Array<any>;
  maid: Array<any>;
  course: Array<any>;
  companySelect: null;
  newLearn: any = {
    maidSelect: null,
    courseSelect: null,
    skillRankSelect: null,
    dateInput: null,
    detailInput: null
  };
  constructor(private adminService: AdminService, private httpClient: HttpClient, private snackbar: MatSnackBar) { }

  ngOnInit() {
    this.adminService.getCompany().subscribe(data => {
      this.company = data;
      console.log(this.company);
    });
    this.adminService.getAllSkillRank().subscribe(data => {
      this.skill = data;
      console.log(this.skill);
    });
  }

  dataChanged() {
    this.adminService.getMaidInCompany(this.companySelect).subscribe(data => {
      this.maid = data;
      console.log(this.maid);
    });
    this.adminService.getCourseInCompany(this.companySelect).subscribe(data => {
      this.course = data;
      console.log(this.course);
    });
  }

  save() {
    if (this.newLearn.maidSelect == null) {
      alert('กรุณาเลือกแม่บ้าน');
    } else if (this.newLearn.courseSelect == null) {
      alert('กรุณาเลือกหลักสูตร');
    } else if (this.newLearn.skillRankSelect == null) {
      alert('กรุณาเลือกระดับทักษะ');
    } else if (this.newLearn.dateInput == null) {
      alert('กรุณาเกรอกเลือกวันที่จบหลักสูตร');
    } else if (this.newLearn.detailInput == null) {
      alert('กรุณากรอกรายละเอียด');
    } else {
      this.save_func();
    }
  }

  save_func() {
    this.httpClient.post('http://localhost:8080/learned/' + this.newLearn.maidSelect +
      '/' + this.newLearn.courseSelect + '/' + this.newLearn.skillRankSelect + '/' + this.newLearn.dateInput + '/' +
      this.newLearn.detailInput, this.newLearn)
      .subscribe(
        data => {
          console.log('PUT Request is successful', data);
          this.snackbar.open('เพิ่มหลักสูตรสำเร็จ', '', {
            duration: 35000, verticalPosition: 'top',
          });
          this.reset_func();
        },
        error => {
          console.log('Rrror', error);
          this.snackbar.open('เกิดข้อผิดพลาด', '', {
            duration: 35000, verticalPosition: 'top',
          });
        }
      );
  }
  reset_func() {
    this.newLearn.maidSelect = null;
    this.newLearn.courseSelect = null;
    this.newLearn.skillRankSelect = null;
    this.newLearn.dateInput = null;
    this.newLearn.detailInput = null;
  }

}
