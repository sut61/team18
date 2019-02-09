import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/internal/Observable';

const complaintAPI = '//localhost:8080'
@Injectable({
  providedIn: 'root'
})
export class ComplaintService {

  constructor(private http:HttpClient) { }

  public getComplaintType():Observable<any>{
    return this.http.get(complaintAPI+'/ComplaintType')
 
  }
 public getCompanyName():Observable<any>{
   return this.http.get(complaintAPI+'/Company')

 }

 public getMaidName():Observable<any>{
  return this.http.get(complaintAPI+'/Maid')

}
 



}
