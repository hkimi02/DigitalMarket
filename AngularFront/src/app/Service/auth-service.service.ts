import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { port } from 'src/env';
@Injectable({
  providedIn: 'root'
})
export class AuthServiceService {

  constructor(private http:HttpClient){
  }
  
  AdddUser(role:any,user:any){
      return this.http.post(`${port}/INFOUSER-SERVICE/addUserInfo?role=${role}`,user);
  }

}
