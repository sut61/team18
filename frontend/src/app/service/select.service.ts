import { Injectable } from '@angular/core';

import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/internal/Observable';

@Injectable({
  providedIn: 'root'
})
export class SelectService {

  
  public API = '//localhost:8080';

  constructor(private http: HttpClient) { }

  getMaidStatusId(): Observable<any> {
    return this.http.get(this.API + '/status');
  }
  getTypeworking(): Observable<any> {
    return this.http.get(this.API + '/typeworking');
  }
  getTypeworkingDate(): Observable<any> {
    return this.http.get(this.API + '/workingDate');
  }
  getCompanyForMaid(): Observable<any>{
    return this.http.get(this.API + '/companys');
  }
  getMaid(): Observable<any>{
    return this.http.get(this.API + '/register');
  }
  getStatus():Observable<any>{
    return this.http.get(this.API + '/status');
  }
 
  saveSelect(data: any): Observable<any> {
    return this.http.post(this.API + '/select', data);
  }
}
