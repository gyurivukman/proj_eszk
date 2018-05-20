import { Component, OnInit, ViewChild } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { JwtHelper } from 'angular2-jwt';
import { RecipesComponent } from '../recipes/recipes.component';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  searchInput:string;
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
  
  filterFrontpage(event:Event){
    let param = event.srcElement.innerHTML
    this.router.navigate(['recipes'], { queryParams: {tag:param}})
  }

  search(){
    this.router.navigate(['recipes'],{queryParams:{search:this.searchInput}})
  }
}
