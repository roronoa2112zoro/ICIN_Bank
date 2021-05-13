import { Injectable } from '@angular/core';
import {TransferHistory} from './_models/transferhistory';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TransferhistoryService {

  private url:String;

  constructor(private http:HttpClient) {
    this.url="http://ec2-3-94-64-169.compute-1.amazonaws.com:8080"
   }
   public getTransferHistory(accNo):Observable<TransferHistory[]>{
    return this.http.get<TransferHistory[]>(this.url+"/account/getTransfers/"+accNo);
  }
  // public getSavingAccount(username):Observable<SavingAccount>{
  //   return this.http.get<SavingAccount>(this.url+"/account/getsaving/"+username);
  // }
}
