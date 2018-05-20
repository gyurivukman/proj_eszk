import { Component, OnInit, OnDestroy, ViewChild, ElementRef } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Subscription } from 'rxjs/Subscription';
import { Recipe } from '../shared/recipe.model';
import { Ingredient } from '../shared/ingredient.model';
import { Comment } from '../shared/comment.model'
import { Http } from '@angular/http';
import { JwtHelper } from 'angular2-jwt';

@Component({
  selector: 'app-recipe',
  templateUrl: './recipe-detail.component.html',
  styleUrls: ['./recipe-detail.component.css']
})
export class RecipeDetailComponent implements OnInit,OnDestroy {

  activatedRouteSub:Subscription;
  recipeData:Recipe;
  commentData:Comment[];
  userComment:string;
  colorPalette:string[] = ['#E2725B','#FFC864','#F58B4C','#CD594A','#A3B86C','#43ABC9']
  constructor(private route:ActivatedRoute,private http:Http,private jwthelper:JwtHelper) {
    
  }

  addComment(){
    this.commentData.push(
      {
        id:1,
        user_id:1,
        username:"LOGGED_IN_USER",
        createdAt:new Date().toLocaleDateString(),
        order:this.commentData.length>0?this.commentData[this.commentData.length-1].order+1:1,
        text:this.userComment.trim()
      }
    )
    this.userComment="";
  }

  ngOnInit() {
    this.activatedRouteSub=this.route.params.subscribe(
      (params)=>{
        this.http.get("/api/recipe/"+params['recipeid']).toPromise().then(
          (res)=>{
            console.log(res.json())
            this.recipeData=res.json();
          }
        ).catch(
          (res)=>{
            console.log("HIBA: ",res)
          }
        )
      }
    )
  }

  isUserCommentInvalid(){
    return this.userComment == null || this.userComment.length<1 || !(/\S/.test(this.userComment))
  }
  ngOnDestroy(){
    this.activatedRouteSub.unsubscribe();
  }

  isUserLoggedIn():boolean{
    let token = localStorage.getItem("token")
    return token!=null && !this.jwthelper.isTokenExpired(token);
  }

  addToShopList(){
    let shopList:any = sessionStorage.getItem("shopList");

    if(!shopList){
      shopList = {}
    }else{
      shopList = JSON.parse(shopList);
    }

    for(let ingredient of this.recipeData.ingredients){  
      console.log(ingredient)
      if(!shopList[ingredient.name]){
        shopList[ingredient.name]={};
        shopList[ingredient.name].quantity=[];
        shopList[ingredient.name].color=this.getBackgroundColor();
      }
      shopList[ingredient.name].quantity.push(ingredient.quantity)
    }

    sessionStorage.setItem("shopList",JSON.stringify(shopList))

  }
  getBackgroundColor():string{
    let index = Math.floor(Math.random()*this.colorPalette.length)
    return this.colorPalette[index];
  }
}
