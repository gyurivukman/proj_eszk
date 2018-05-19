import { Injectable } from '@angular/core';
import { User } from '../shared/user.model';
import { Http } from '@angular/http';

@Injectable()
export class LoginService {

  constructor(private http:Http) {}

  attemptLogin(username:string,password:string):Promise<any>{
    return this.http.post("/api/user/login",{"username":username,"password":password}).toPromise();
  }

}
