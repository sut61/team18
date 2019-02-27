import { Component, OnInit } from '@angular/core';
import {AdminService} from '../service/admin.service';
import {HttpClient} from '@angular/common/http';

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
  constructor(private adminService: AdminService, private httpClient: HttpClient) { }

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
          alert('เพิ่มหลักสูตรสำเร็จ');
          this.reset_func();
        },
        error => {
          console.log('Rrror', error);
          alert('เกิดข้อผิดพลาด');
        }
      );
  }
  reset_func() {
  }

}
