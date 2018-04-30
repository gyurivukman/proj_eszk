import { Component, OnInit } from '@angular/core';
import { FormGroup } from '@angular/forms';

@Component({
  selector: 'app-fridge',
  templateUrl: './fridge.component.html',
  styleUrls: ['./fridge.component.css']
})
export class FridgeComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

  fridgeSearch(formGroup:FormGroup){
    console.log(formGroup.value)
  }
}
