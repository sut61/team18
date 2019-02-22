import { Component, OnInit, Input } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { PaymentService } from '../service/payment.service';
import { Router, ActivatedRoute } from '@angular/router';
import {MatSnackBar} from '@angular/material';
@Component({
  selector: 'app-payment',
  templateUrl: './payment.component.html',
  styleUrls: ['./payment.component.css']
})
export class PaymentComponent implements OnInit {
  typepayments: Array<any>;
  banks: Array<any>;
  contracts: Array<any>;
  pay: any = {
    name : null,
    accountnumber: null,
    address: null,
    phonenum: null,
    bank: null,
    typepayment: null,
    contract: null,
    inputEmail: ''
  };
  constructor(private router: Router, private route: ActivatedRoute,
    private paymentService: PaymentService, private httpClient: HttpClient, private snackbar: MatSnackBar) {
    this.pay.inputEmail = this.route.snapshot.paramMap.get('inputEmail');
    console.log(this.pay.inputEmail);
  }

  ngOnInit() {
    this.paymentService.getBank().subscribe( data => {
      this.banks = data;
      console.log(this.banks);
    });
    this.paymentService.getTypepayment().subscribe(data => {
      this.typepayments = data;
      console.log(this.typepayments);
    });
    this.paymentService.getContract(this.pay.inputEmail).subscribe(data => {
      this.contracts = data;
      if (this.contracts.length === 0) {
        alert('ไม่มีรายการค้างชำระ');
      }
      console.log(this.contracts);
    });
  }
  refreshPay() {
    this.paymentService.getContract2(this.pay.inputEmail).subscribe(data => {
      this.contracts = data;
      console.log(this.contracts);
    });
  }
  save() {
    if (this.pay.name == null || this.pay.contract == null || this.pay.phonenum == null || this.pay.accountnumber == null
      || this.pay.address == null || this.pay.bank == null || this.pay.typepayment == null) {
      this.snackbar.open('กรุณากรอกข้อมูลให้ครบถ้วน', '', {
        duration: 3500, verticalPosition: 'top',
      });
  } else {
    this.httpClient.get('http://localhost:8080/payment/' + this.pay.inputEmail + '/' + this.pay.contract
    + '/' + this.pay.name + '/' + this.pay.address + '/' + this.pay.phonenum + '/'
    + this.pay.accountnumber + '/' + this.pay.typepayment + '/' + this.pay.bank).subscribe(
      data => {
        console.log('PUT Request is successful', data);
        this.snackbar.open('ชำระเงินสำเร็จ', '', {
          duration: 3500, verticalPosition: 'top',
        });
        this.refreshPay();
      },
      error => {
        console.log('Rrror', error);
        this.snackbar.open('เกิดข้อผิดพลาด', '', {
          duration: 3500, verticalPosition: 'top',
        });
      }
    );
    this.resetfield();
  }
}
  resetfield() {
    this.pay.accountnumber = null;
    this.pay.bank = null;
    this.pay.contract = null;
    this.pay.phonenum = null;
    this.pay.name = null;
    this.pay.address = null;
    this.pay.typepayment = null;
  }
}
