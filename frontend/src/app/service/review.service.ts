import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class ReviewService {
  public API = '//localhost:8080';
  check : Boolean


  constructor(private http: HttpClient) { 
  }
  getScoreId() :  Observable<any>{
    return this.http.get(this.API+'/Score');
  }
  getScoreExId() :  Observable<any>{
    return this.http.get(this.API+'/ScoreExt');
  }
  getScorePerId() :  Observable<any>{
    return this.http.get(this.API+'/Scoreper');
  }
  getScoreTiId() :  Observable<any>{
    return this.http.get(this.API+'/ScoreTi');
  }
  
  getMaidId() :  Observable<any>{
    return this.http.get(this.API+'/MMaidRegister');
  }
  saveReview(data:any): Observable<any>{
    return this.http.post(this.API+'/review',data);
 }
 
getReview() :  Observable<any>{
  return this.http.get(this.API+'/rerere');
}




}
