import { Component, OnInit } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-fridge',
  templateUrl: './fridge.component.html',
  styleUrls: ['./fridge.component.css']
})
export class FridgeComponent implements OnInit {

  constructor(private router:Router) { }

  ngOnInit() {
  }

  fridgeSearch(formGroup:FormGroup){
    let params={
      "include":[],
      "exclude":[]
    }
    for(let key of Object.keys(formGroup.value)){
      if(formGroup.value[key].length>0){
        if(key.includes("Include")) params.include.push(formGroup.value[key])
        else params.exclude.push(formGroup.value[key])
      }
    }
    this.router.navigate(['recipes'],{queryParams:params})
  }
}
