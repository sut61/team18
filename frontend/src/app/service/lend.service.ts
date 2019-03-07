import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class LendService {
  public API = '//localhost:8080';
  check : Boolean

  constructor(private http: HttpClient) { 

  }

  getCleaningId() :  Observable<any>{
    return this.http.get(this.API+'/CleaningEquipment');
  }

  getCustomerId() :  Observable<any>{
    return this.http.get(this.API+'/Customer');
  }



  getMaidId() :  Observable<any>{
    return this.http.get(this.API+'/Register');
  }
  
  saveLendEquipment(data:any): Observable<any>{
    return this.http.post(this.API+'/datalend',data);
 }

}
