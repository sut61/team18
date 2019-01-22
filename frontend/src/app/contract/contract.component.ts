import { Component, OnInit } from '@angular/core';
import { AdminService } from '../service/admin.service';
import { HttpClient } from '@angular/common/http';
import { SelectionModel } from '@angular/cdk/collections';
import { matDialogAnimations } from '@angular/material';

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
  paymentStatus: Array<any>;
  contract: any = {
    companySelect: null,
    maidSelect: null,
    contractTypeSelect: null,
    promotionSelect: null,
    dateStartInput: null
  };

  private id: number;
  private sub: any;

  constructor(private adminService: AdminService, private httpClient: HttpClient) { }

  ngOnInit() {
    this.adminService.getCompany().subscribe(data => {
      this.companys = data;
      console.log(this.companys);
    });
    this.adminService.getContractType().subscribe(data => {
      this.contractTypes = data;
      console.log(this.contractTypes);
    });
    this.adminService.getPaymentStatus().subscribe(data => {
      this.paymentStatus = data;
      console.log(this.paymentStatus);
    });
    this.adminService.getAllMaid().subscribe(data => {
      this.maids = data;
      console.log(this.maids);
    });
  }

  isAllSelected() {
    const numSelected = this.selection.selected.length;
    const numRows = this.maids.length;
    if (numSelected !== 0) {
      this.maids[numSelected - 1].maidSelectId = this.id;
    }
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
      console.log(this.promotions);
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
      alert("กรุณาเลือกบริษัท");
    }
    else if (this.contract.maidSelect == null) {
      alert("กรุณาเลือกแม่บ้าน");
    }
    else if (this.contract.contractTypeSelect == null) {
      alert("กรุณาเลือกประเภทสัญญา");
    }
    else if (this.contract.dateStartInput == null) {
      alert("กรุณาเลือกวันเริ่มสัญญา");
    }
    else {
      if (this.contract.promotionSelect == '' || this.contract.promotionSelect == null) {
        this.contract.promotionSelect = "No Promotion";
      }
      console.log(this.contract);
      this.save_func();
    }
  }
  save_func() {
    this.httpClient.post('http://localhost:8080/contract/' + this.contract.companySelect + '/' + this.contract.maidSelect + '/' + this.contract.contractTypeSelect + '/' + this.contract.promotionSelect + '/' + this.contract.dateStartInput, this.contract)
      .subscribe(
        data => {
          console.log('PUT Request is successful', data);
          alert('บันทึกสัญญาสำเร็จ');
          this.reset_func();
        },
        error => {
          console.log('Rrror', error);
          alert('เกิดข้อผิดพลาด');
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
  }
}
