import { Component, OnInit, Input } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { PaymentService } from '../service/payment.service';
import { Router, ActivatedRoute } from '@angular/router';
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
    inputEmail: 'sut@gg.com'
  };
  constructor(private router: Router, private route: ActivatedRoute,
    private paymentService: PaymentService, private httpClient: HttpClient) { }

  ngOnInit() {
    this.paymentService.getBank().subscribe( data => {
      this.banks = data;
      console.log(this.banks);
    });
    this.paymentService.getTypepayment().subscribe(data => {
      this.typepayments = data;
      console.log(this.typepayments);
    });
    this.paymentService.getContract().subscribe(data => {
      this.contracts = data;
      console.log(this.contracts);
    });
  }
  save() {
    if (this.pay.name == null || this.pay.contract == null || this.pay.phonenum == null || this.pay.accountnumber == null
      || this.pay.address == null || this.pay.bank == null || this.pay.typepayment == null) {
        alert('กรุณาเลือกและกรอกข้อมูลให้ครบถ้วน');
  } else {
    this.httpClient.get('http://localhost:8080/payment/' + this.pay.inputEmail + '/' + this.pay.contract
    + '/' + this.pay.name + '/' + this.pay.address + '/' + this.pay.phonenum + '/'
    + this.pay.accountnumber + '/' + this.pay.typepayment + '/' + this.pay.bank).subscribe(
      data => {
        console.log('PUT Request is successful', data);
        alert('ชำระเงินสำเร็จ');
        location.reload();
      },
      error => {
        console.log('Rrror', error);
        alert('เกิดข้อผิดพลาด');
      }
    );
  }
}
}
