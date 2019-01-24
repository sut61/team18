import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/internal/Observable';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {
  public API = '//localhost:8080';
  constructor(private http: HttpClient) { }

  getTitlename():Observable<any>{
    return this.http.get(this.API + '/TitleNameEntity');
  }
  getCustomersex():Observable<any>{
    return this.http.get(this.API + '/sex');
  }
  getCountryCode():Observable<any>{
    return this.http.get(this.API + '/countryCode');
  }
  getCustomerAccount(email):Observable<any>{
    return this.http.get(this.API + '/customer/'+email);
  }
}
