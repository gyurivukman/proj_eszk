import { Component, OnInit } from '@angular/core';
import { FormGroup } from '@angular/forms';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  constructor() { }

  ngOnInit() {}

  attemptLogin(loginForm:FormGroup){
    console.log(loginForm)
  }

  attemptSignup(signupForm:FormGroup){
    console.log(signupForm.value)
  }

}
