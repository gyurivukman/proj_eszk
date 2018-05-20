import { Component, OnInit } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { JwtHelper } from 'angular2-jwt';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  constructor(private router:Router,private jwthelper:JwtHelper) {}

  ngOnInit() {}

  isUserLoggedIn(){
    let token = localStorage.getItem("token");
    return token != null && !this.jwthelper.isTokenExpired(token);
  }

  logout(){
    localStorage.removeItem("token");
    sessionStorage.removeItem("shopList");
    this.router.navigate(['/recipes'])
  }
}
