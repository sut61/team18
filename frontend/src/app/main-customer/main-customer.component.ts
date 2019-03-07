import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-main-customer',
  templateUrl: './main-customer.component.html',
  styleUrls: ['./main-customer.component.css']
})
export class MainCustomerComponent implements OnInit {
  inputEmail: any ;
  constructor(private router: Router, private route: ActivatedRoute) {
    this.inputEmail = this.route.snapshot.paramMap.get('customerEmail');
  }

  ngOnInit() {
  }
  goPayment() {
    this.router.navigate(['/payment', this.inputEmail]);
  }
  select(){
    this.router.navigate(['/select', this.inputEmail]);
  }
}
