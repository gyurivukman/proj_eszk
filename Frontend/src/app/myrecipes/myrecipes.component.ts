import { Component, OnInit } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { Ingredient } from '../shared/ingredient.model';
import { Preparation } from '../shared/preparation.model';

@Component({
  selector: 'app-myrecipes',
  templateUrl: './myrecipes.component.html',
  styleUrls: ['./myrecipes.component.css']
})
export class MyrecipesComponent implements OnInit {
  title:string;
  description:string;
  ingredients:Ingredient[]=[];
  steps:Preparation[]=[];
  isEditorVisible:boolean=false
  tags:string[]=[]
  tmpTag:string="";
  difficulty:string="";
  readyIn:number;

  constructor() {}
  ngOnInit() {}

  showEditor(){
    this.isEditorVisible=true;
  }

  hideEditor(){
    this.isEditorVisible=false;
  }

  attemptAddNewRecipe(){
    console.log("Needs Backend connection!")
  }

  addIngredient(){
    this.ingredients.push({
      name:"",
      quantity:""
    });
  }

  addStep(){
    this.steps.push({
      stepOrder:this.steps.length+1,
      text:""
    })
  }

  pollServerForIngredient(){

  }

  removeIngredient(index:number){
    this.ingredients.splice(index,1)
  }

  removeStep(index:number){
    this.steps.splice(index,1);
    for(let i=0;i<this.steps.length;++i){
      this.steps[i].stepOrder=i+1;
    }
  }
  
  addTag(){
    this.tags.push(this.tmpTag)
    this.tmpTag="";
  }

  removeTag(index:number){
    this.tags.splice(index,1);
    this.tmpTag="";
  }

}
