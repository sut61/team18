import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/internal/Observable';
import { ObservableInput } from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class CompanyService {
  public API = '//localhost:8080';
  constructor(private http: HttpClient) { }
  getCompanytype(): Observable<any>{
    return this.http.get(this.API + '/CompanyType');
  }
  getProvince(): Observable<any>{
    return this.http.get(this.API + '/province');
  }
}
