import { WelfaresalaryService } from './../service/welfaresalary.service';
import { Component, OnInit, ViewChild} from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { MatTableDataSource, MatPaginator} from '@angular/material';

@Component({
  selector: 'app-welfareandsalary',
  templateUrl: './welfareandsalary.component.html',
  styleUrls: ['./welfareandsalary.component.css']
})
export class WelfareandsalaryComponent implements OnInit {
  typewelfares: Array<any>;
  companys: Array<any>;
  typeworks: Array<any>;
  welfareSalary:  MatTableDataSource<any>;
  @ViewChild(MatPaginator) paginator: MatPaginator;
  displayedColumns: String[] = ['name', 'typeWel', 'typeWork', 'salary'];
  welsa: any =  {
    company: null,
    typework: null,
    typewel: null,
    salary: null,
    welsaName: null,
    detail: null,
    termcon: null
  };
  constructor(private welfaresalaryService: WelfaresalaryService, private httpClient: HttpClient) { }

  ngOnInit() {
    this.welfaresalaryService.getCompanyName().subscribe( data => {
        this.companys = data;
        console.log(this.companys);
    });
    this.welfaresalaryService.getTypeworking().subscribe( data => {
        this.typeworks = data;
        console.log(this.typeworks);
    });
    this.welfaresalaryService.getTypewelfare().subscribe( data => {
        this.typewelfares = data;
        console.log(this.typewelfares);
    });
    this.welfaresalaryService.getWelfareSalary().subscribe( data => {
        this.welfareSalary = new MatTableDataSource(data);
        console.log(this.welfareSalary);
        this.welfareSalary.paginator = this.paginator;
    });
  }
  save() {
    if (this.welsa.company == null || this.welsa.typework == null
      || this.welsa.typewel == null || this.welsa.salary == null || this.welsa.welsaName == null ||
      this.welsa.detail == null || this.welsa.termcon == null) {
        alert('กรุณากรอกข้อมูลให้ครบถ้วน');
      } else {
        this.httpClient.get('http://localhost:8080/welsa/' + this.welsa.company + '/' + this.welsa.typework + '/'
        + this.welsa.typewel + '/' + this.welsa.welsaName + '/' + this.welsa.salary + '/' + this.welsa.detail + '/'
        + this.welsa.termcon).subscribe(
          data => {
            console.log('PUT Request is successful', data);
            this.updateTable();
            alert('บันทึกสวัสดิการและผลตอบแทนสำเร็จ');
          },
          error => {
            console.log('Rrror', error);
            alert('เกิดข้อผิดพลาด');
          }
        );
        this.resetField();
      }
  }
  resetField() {
    this.welsa.company = null;
    this.welsa.typework = null;
    this.welsa.typewel = null;
    this.welsa.salary = null;
    this.welsa.welsaName = null;
    this.welsa.detail = null;
    this.welsa.termcon = null;
  }
  updateTable() {
    this.welfaresalaryService.getWelfareSalary().subscribe( data => {
      this.welfareSalary = new MatTableDataSource(data);
      this.welfareSalary.paginator = this.paginator;
      console.log(this.welfareSalary);
  });
  }

}
