import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/internal/Observable';
@Injectable({
  providedIn: 'root'
})
export class AdminService {
  public API = '//localhost:8080';

  constructor(private http: HttpClient) { }

  getAdminAccount(adminUsername): Observable<any> {
    return this.http.get(this.API + '/admin/' + adminUsername);
  }

  getCompany(): Observable<any> {
    return this.http.get(this.API + '/company');
  }

  getAllMaid(): Observable<any> {
    return this.http.get(this.API + '/maid/reserve');
  }

  getMaidSelect(companySelect): Observable<any> {
    return this.http.get(this.API + '/maid/getdata/' + companySelect);
  }

  getPromotion(companySelect): Observable<any> {
    return this.http.get(this.API + '/promotion/getdata/' + companySelect);
  }

  getContractType(): Observable<any> {
    return this.http.get(this.API + '/contractType');
  }

  getContract(): Observable<any> {
    return this.http.get(this.API + '/contract');
  }

}
