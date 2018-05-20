import { Component, OnInit, Pipe, PipeTransform } from '@angular/core';

@Component({
  selector: 'app-shop',
  templateUrl: './shop.component.html',
  styleUrls: ['./shop.component.css']
})
export class ShopComponent implements OnInit {

  shopList:{};
  constructor() { }

  ngOnInit() {
    let tmp = sessionStorage.getItem("shopList")
    if(tmp) this.shopList = JSON.parse(tmp);
  }

  removeIngredientQuantity(key:string, index:number){
    this.shopList[key].quantity.splice(index,1);
    sessionStorage.setItem("shopList",JSON.stringify(this.shopList));
  }

  removeIngredientCategory(key:string){
    delete this.shopList[key]
    sessionStorage.setItem("shopList",JSON.stringify(this.shopList));
  }
}
