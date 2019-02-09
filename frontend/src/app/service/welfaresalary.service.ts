import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/internal/Observable';

@Injectable({
  providedIn: 'root'
})
export class WelfaresalaryService {

  public API = '//localhost:8080';
  constructor(private http: HttpClient) { }

  getTypewelfare(): Observable<any> {
    return this.http.get(this.API + '/typewelfare');
  }
  getTypeworking(): Observable<any> {
    return this.http.get(this.API + '/workingDate');
  }
  public getCompanyName(): Observable<any> {
    return this.http.get(this.API + '/Company');
  }
  public getWelfareSalary(): Observable<any> {
    return this.http.get(this.API + '/welsa');
  }
}
