import { Component, OnInit } from '@angular/core';
import { AdminService } from '../service/admin.service';
import { HttpClient } from '@angular/common/http';
import { SelectionModel } from '@angular/cdk/collections';
import { matDialogAnimations } from '@angular/material';
export interface ContractElement {
}

@Component({
  selector: 'app-edit-contract',
  templateUrl: './edit-contract.component.html',
  styleUrls: ['./edit-contract.component.css']
})
export class EditContractComponent implements OnInit {
  displayedColumns: string[] = ['select', 'no', 'maidName', 'company', 'customer', 'contractType', 'cost'];
  selection = new SelectionModel<ContractElement>(true, []);

  allContracts: Array<any>;
  contractTypes: Array<any>;
  contract: any = {
    companySelect: null,
    maidSelect: null,
    customerSelect: null,
    contractTypeSelect: null,
    promotionSelect: null,
    dateStartInput: null,
    contractId: null,
    cost: null
  };

  private id: number;
  private sub: any;
  constructor(private adminService: AdminService, private httpClient: HttpClient) { }

  ngOnInit() {
    this.adminService.getContract().subscribe(data => {
      this.allContracts = data;
      console.log(this.allContracts);
    });
    this.adminService.getContractType().subscribe(data => {
      this.contractTypes = data;
      console.log(this.contractTypes);
    });
  }

  isAllSelected() {
    const numSelected = this.selection.selected.length;
    const numRows = this.allContracts.length;
    return numSelected === numRows;
  }

  masterToggle() {
    this.isAllSelected() ?
      this.selection.clear() :
      this.allContracts.forEach(row => this.selection.select(row));
  }

  selectRow(row) {
    this.selection.toggle(row);
    this.contract.companySelect = row.maid.maid.companyForMaid.companyName;
    this.contract.maidSelect = row.maid.maid.maidName;
    this.contract.customerSelect = row.customer.customerName;
    this.contract.contractTypeSelect = row.contractType.contractType;
    this.contract.dateStartInput = new Date(row.dateStart);
    this.contract.contractId = row.contractId;
    this.contract.cost = row.cost;
  }

  update() {
    this.httpClient.put('http://localhost:8080/contract/update/' + this.contract.contractTypeSelect + '/' + this.contract.dateStartInput + '/' + this.contract.contractId + '/' + this.contract.cost, this.contract)
      .subscribe(
        data => {
          console.log('UPDATE Request is successful', data);
          alert('แก้ไขสัญญาสำเร็จ');
          this.reset_func();
        },
        error => {
          console.log('Error', error);
          alert('แก้ไขสัญญาไม่สำเร็จ');
        }
      );
  }

  delete() {
    this.httpClient.delete('http://localhost:8080/contract/' + this.contract.contractId)
      .subscribe(
        data => {
          console.log('DELETE Request is successful', data);
          this.reset_func();
        },
        error => {
          console.log('Error', error);
        }
      );
  }
  reset_func() {
    this.adminService.getContract().subscribe(data => {
      this.allContracts = data;
      console.log(this.allContracts);
    });
  }
}
