import {Component, OnInit} from '@angular/core';
import {AdminService} from '../service/admin.service';
import {HttpClient} from '@angular/common/http';
import {SelectionModel} from '@angular/cdk/collections';
import {MatSnackBar} from '@angular/material';
import {matDialogAnimations} from '@angular/material';

export interface ContractElement {
}

@Component({
  selector: 'app-contract',
  templateUrl: './contract.component.html',
  styleUrls: ['./contract.component.css']
})
export class ContractComponent implements OnInit {
  displayedColumns: string[] = ['select', 'no', 'name', 'company', 'tel', 'cusName'];
  selection = new SelectionModel<ContractElement>(true, []);

  companys: Array<any>;
  maids: Array<any>;
  promotions: Array<any>;
  contractTypes: Array<any>;
  contract: any = {
    companySelect: null,
    maidSelect: null,
    contractTypeSelect: null,
    promotionSelect: null,
    dateStartInput: null,
    cost: null,
    detail: null
  };

  private id: number;
  private sub: any;

  constructor(private adminService: AdminService, private httpClient: HttpClient, private snackbar: MatSnackBar) {
  }

  ngOnInit() {
    this.adminService.getCompany().subscribe(data => {
      this.companys = data;
      console.log(this.companys);
    });
    this.adminService.getContractType().subscribe(data => {
      this.contractTypes = data;
      console.log(this.contractTypes);
    });
    this.adminService.getAllMaid().subscribe(data => {
      this.maids = data;
      console.log(this.maids);
    });
  }

  isAllSelected() {
    const numSelected = this.selection.selected.length;
    const numRows = this.maids.length;
    return numSelected === numRows;
  }

  masterToggle() {
    this.isAllSelected() ?
      this.selection.clear() :
      this.maids.forEach(row => this.selection.select(row));
  }

  selectRow(row) {
    this.selection.toggle(row);
    this.contract.companySelect = row.maid.companyForMaid.companyName;
    this.contract.maidSelect = row.maid.maidName;
    this.adminService.getPromotion(this.contract.companySelect).subscribe(data => {
      this.promotions = data;
    });
    console.log(this.contract);
  }

  maidData() {
    this.adminService.getMaidSelect(this.contract.companySelect).subscribe(data => {
      this.maids = data;
      console.log(this.maids);
    });
    this.adminService.getPromotion(this.contract.companySelect).subscribe(data => {
      this.promotions = data;
      console.log(this.promotions);
    });
  }

  dataChanged() {
    if (this.contract.companySelect) {
      this.maidData();
    } else {
      this.adminService.getAllMaid().subscribe(data => {
        this.maids = data;
        console.log(this.maids);
      });
    }
  }

  save() {
    if (this.contract.companySelect == null) {
      alert('กรุณาเลือกบริษัท');
    } else if (this.contract.maidSelect == null) {
      alert('กรุณาเลือกแม่บ้าน');
    } else if (this.contract.contractTypeSelect == null) {
      alert('กรุณาเลือกประเภทสัญญา');
    } else if (this.contract.dateStartInput == null) {
      alert('กรุณาเลือกวันเริ่มสัญญา');
    } else if (this.contract.detail == null) {
      alert('กรุณาเกรอกรายละเอียดสัญญา');
    } else {
      if (this.contract.promotionSelect === '' || this.contract.promotionSelect == null) {
        this.contract.promotionSelect = 'No Promotion';
      }
      console.log(this.contract);
      this.save_func();
    }
  }

  save_func() {
    this.httpClient.post('http://localhost:8080/contract/' + this.contract.companySelect + '/' + this.contract.maidSelect + '/' +
      this.contract.contractTypeSelect + '/' + this.contract.promotionSelect + '/' + this.contract.dateStartInput + '/' +
      this.contract.cost + '/' + this.contract.detail , this.contract)
      .subscribe(
        data => {
          console.log('PUT Request is successful', data);
          this.snackbar.open('บันทึกสัญญาสำเร็จ', '', {
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
    this.adminService.getAllMaid().subscribe(data => {
      this.maids = data;
      console.log(this.maids);
    });
    this.adminService.getCompany().subscribe(data => {
      this.companys = data;
      console.log(this.companys);
    });
    this.contract.companySelect = null;
    this.contract.maidSelect = null;
    this.contract.contractTypeSelect = null;
    this.contract.promotionSelect = null;
    this.contract.dateStartInput = null;
    this.contract.cost = null;
    this.contract.detail = null;
  }
}
