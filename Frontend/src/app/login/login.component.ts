import { Component, OnInit, ViewChild, ElementRef } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { AuthHttp } from 'angular2-jwt';
import { Http } from '@angular/http';
import { LoginService } from './login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  @ViewChild('closeLogin') closeLogin: ElementRef;
  loginError:boolean;
  constructor(private loginservice:LoginService) { 
  }

  ngOnInit() {
    this.loginError=false;
  }

  attemptLogin(formGroup:FormGroup){
    let logindata = formGroup.value;
    this.loginservice.attemptLogin(logindata['username'], logindata['password']).then(
      (res)=>{
        localStorage.setItem("token", res.json()['token']);
        this.closeModal();
      }
    ).catch(
      (res)=>{
        this.loginError=true;
      }
    );
  }

  closeModal(){
    this.closeLogin.nativeElement.click()
  }
}
