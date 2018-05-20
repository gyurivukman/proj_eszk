import { Injectable } from '@angular/core';
import { Http } from '@angular/http';
import { SignUpData } from '../shared/signup-data.model';

@Injectable()
export class SignupService {

  constructor(private http:Http) { }

  attemptSignup(data:SignUpData):Promise<any>{
    return this.http.post("/api/user/register", data).toPromise()
  }

}
