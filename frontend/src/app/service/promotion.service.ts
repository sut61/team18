import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/internal/Observable';

const promotionAPI = '//localhost:8080'
@Injectable({
  providedIn: 'root'
})
export class PromotionService {
  
  constructor(private http:HttpClient) { 

   
  }
  public getPromotionType():Observable<any>{
    return this.http.get(promotionAPI+'/PromotionType')
 
  }
 public getCompanyName():Observable<any>{
   return this.http.get(promotionAPI+'/Company')

 }
 
 public getMaidName():Observable<any>{
  return this.http.get(promotionAPI+'/maid')

}
 
}
