import { Component, OnInit } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { AuthHttp } from 'angular2-jwt';
import { Http } from '@angular/http';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private http:Http) { 
  }

  ngOnInit() {
  }

  attemptLogin(formGroup:FormGroup){
    this.http.post('/api/user/login',formGroup.value).toPromise().then(
      (response)=>{
        localStorage.setItem("token",response.json()['token'])
      }
    )
  }
}
