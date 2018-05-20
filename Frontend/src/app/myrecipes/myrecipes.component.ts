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
      step:this.steps.length+1,
      description:""
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
      this.steps[i].step=i+1;
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

  myrecipes = [
    {
      id: 1,
      title: 'Ez egy ciEz egy ciEz egy ciEz egy y ciEz egy ciEz egy ciEz egyy ciEz egy ciEz egy ciEz egyy ciEz egy ciEz egy ciEz egyciEz egy ciEz egy ciEz egy cim',
      text: 'Neque porro lor sit amet, consectetuer adipiscing elit. CurLorem ipsum dolor sit amet, consectetuelor sit amet, consectetuer adipiscing elit. CurLorem ipsum dolor sit amet, consectetuelor sit amet, consectetuer adipiscing elit. CurLorem ipsum dolor sit amet, consectetuelor sit amet, consectetuer adipiscing elit. CurLorem ipsum dolor sit amet, consectetue est qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit',
      imgUrl: 'https://i.imgur.com/bE4jFyr.jpg'
    },
    {
      id: 2,
      title: 'Ez egy másik nagyon gerely cim',
      text: 'Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Curabitur non augue et nisi porttitor pretium.',
      imgUrl: 'https://i.imgur.com/yDD0LCR.jpg'
    },
    {
      id: 3,
      title: 'Hova tetted az overálomat?',
      text: 'Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Curabitur non augue et nisi porttitor pretium.',
      imgUrl: 'https://i.imgur.com/b0awqEb.jpg'
    },
    {
      id: 4,
      title: 'Ez egy cim',
      text: 'Neque porro quisquam est qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit',
      imgUrl: 'https://i.imgur.com/bE4jFyr.jpg'
    },
    {
      id: 5,
      title: 'Ez egy másik nagyon gerely cim',
      text: 'Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Curabitur non augue et nisi porttitor pretium.',
      imgUrl: 'https://i.imgur.com/yDD0LCR.jpg'
    },
    {
      id: 6,
      title: 'Hova tetted az overálomat?',
      text: 'Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Curabitur non augue et nisi porttitor pretium.',
      imgUrl: 'https://i.imgur.com/b0awqEb.jpg'
    },
    {
      id: 7,
      title: 'Ez egy cim',
      text: 'Neque porro quisquam est qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit',
      imgUrl: 'https://i.imgur.com/bE4jFyr.jpg'
    },
    {
      id: 8,
      title: 'Ez egy másik nagyon gerely cim',
      text: 'Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Curabitur non augue et nisi porttitor pretium.',
      imgUrl: 'https://i.imgur.com/yDD0LCR.jpg'
    },
    {
      id: 9,
      title: 'Hova tetted az overálomat?',
      text: 'Lorem ipsum dolor sit amet, consectetuer adipiscing elit. CurLorem ipsum dolor sit amet, consectetuer adipiscing elit. CurLorem ipsum dolor sit amet, consectetuer adipiscing elit. CurLoremLorem ipsum dolor sit amet, consectetuer adipiscing elit. CurLorem ipsum dolor sit amet, consectetuer adipiscing elit. CurLorem ipsum dolor sit amet, consectetuer adipiscing elit. CurLorem ipsum dolor sit amet, consectetuer adipiscing elit. CurLorem ipsum dolor sit amet, consectetuer adipiscing elit. CurLorem ipsum dolor sit amet, consectetuer adipiscing elit. Cur ipsum dolor sit amet, consectetuer adipiscing elit. CurLorem ipsum dolor sit amet, consectetuer adipiscing elit. CurLorem ipsum dolor sit amet, consectetuer adipiscing elit. Curabitur non augue et nisi porttitor pretium.',
      imgUrl: 'https://i.imgur.com/b0awqEb.jpg'
    }
  ];

}
