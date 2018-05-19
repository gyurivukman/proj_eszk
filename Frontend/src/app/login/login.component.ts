import { Component, OnInit, ViewChild, ElementRef } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { AuthHttp } from 'angular2-jwt';
import { Http } from '@angular/http';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  @ViewChild('closeLogin') closeLogin: ElementRef;
  loginError:boolean;
  constructor(private http:Http) { 
  }

  ngOnInit() {
    this.loginError=false;
  }

  attemptLogin(formGroup:FormGroup){
    this.http.post('/api/user/login',formGroup.value).toPromise().then(
      (response)=>{
        localStorage.setItem("token",response.json()['token']);
        this.closeLogin.nativeElement.click()
      }
    ).catch((res)=>{
      this.loginError=true;
    })
  }
}
