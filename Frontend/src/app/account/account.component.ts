import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-account',
  templateUrl: './account.component.html',
  styleUrls: ['./account.component.css']
})
export class AccountComponent implements OnInit {
  data ={
    id:1,
    username:"USERNAME PLACEHOLDER",
    first_name:"FIRSTNAME",
    second_name:"SECONDNAME",
    email:"EMAIL",
    recipeCount:5,
    commentCount:100
  }

  constructor() { }

  ngOnInit() {
  }

}
