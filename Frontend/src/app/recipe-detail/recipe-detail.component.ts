import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Subscription } from 'rxjs/Subscription';
import { Recipe } from '../shared/recipe.model';
import { Ingredient } from '../shared/ingredient.model';

@Component({
  selector: 'app-recipe',
  templateUrl: './recipe-detail.component.html',
  styleUrls: ['./recipe-detail.component.css']
})
export class RecipeDetailComponent implements OnInit,OnDestroy {

  activatedRouteSub:Subscription;
  recipeData:Recipe;
  commentData;
  constructor(private route:ActivatedRoute) {
    
  }

  ngOnInit() {
    this.activatedRouteSub=this.route.params.subscribe(
      (params)=>{
        this.recipeData = {
          id:Number(params['recipeid']),
          name:"Szuper Duper Palacsinta Deluxe",
          description:"Lent voltunk vidéken aztán ez volt.The end.",
          imgPath:"https://www.biggerbolderbaking.com/wp-content/uploads/2016/03/BBB117-Carrot-Cake-Pancakes-Thumbnail-FINAL-1024x576.jpg",
          ingredients:[
            {name:'Szuper', quantity:'9001'},
            {name:'Duper', quantity:'15 dkg'},
            {name:'Palacsinta', quantity:'1 db közepes'},
            {name:'Mittomén', quantity:'3 cups'}
          ],
          steps:[
            {
              step:1,
              description:"Szeleteld"
            },
            {
              step:2,
              description:"Keverd"
            },
            {
              step:3,
              description:"Süssed"
            },
            {
              step:4,
              description:"Add a kutyának"
            }
          ],
          rating:8.1,
          creator:{
            username:'Mr. User',
            surname:'Dr. Mr. Sir',
            forename:'Júzer',
            avatar:'http://i0.kym-cdn.com/photos/images/newsfeed/000/869/487/ccf.png'
          },
          readyIn:40,
          difficulty:"Easy",
          createdAt:"2015-06-15T09:03:01+0900",
          tags:["tag1","tag2","tag1","tag2","tag1","tag2","tag1","tag2","tag1","tag2","tag1","tag2","tag1","tag2","tasdasdasdasdasdasasasdag1","tag2","tag1","tag2","tag1","tag2","tag1","tag2","tag1","tag2"]
        }
        this.commentData = [{
          creator:"CREATOR_1",
          avatar:"http://i0.kym-cdn.com/photos/images/newsfeed/000/869/487/ccf.png",
          date:"2018-05-20",
          text:"Lorem ipsum, dolor sit amet consectetur adipisicing elit. Dolor nesciunt ipsum, reiciendis quos corrupti ullam, hic maxime, eos fuga tempore tenetur nostrum tempora. Eligendi ducimus laudantium, aliquam dolore quam ipsa!Lorem ipsum, dolor sit amet consectetur adipisicing elit. Dolor nesciunt ipsum, reiciendis quos corrupti ullam, hic maxime, eos fuga tempore tenetur nostrum tempora. Eligendi ducimus laudantium, aliquam dolore quam ipsa!Lorem ipsum, dolor sit amet consectetur adipisicing elit. Dolor nesciunt ipsum, reiciendis quos corrupti ullam, hic maxime, eos fuga tempore tenetur nostrum tempora. Eligendi ducimus laudantium, aliquam dolore quam ipsa!"
        },{
          creator:"CREATOR_2",
          avatar:"http://i0.kym-cdn.com/photos/images/newsfeed/000/869/487/ccf.png",
          date:"2018-05-21",
          text:"Lorem ipsum, dolor sit amet consectetur adipisicing elit. Dolor nesciunt ipsum, reiciendis quos corrupti ullam, hic maxime, eos fuga tempore tenetur nostrum tempora. Eligendi ducimus laudantium, aliquam dolore quam ipsa!"
        },{
          creator:"CREATOR_3",
          avatar:"http://i0.kym-cdn.com/photos/images/newsfeed/000/869/487/ccf.png",
          date:"2018-05-22",
          text:"Lorem ipsum, dolor sit amet consectetur adipisicing elit. Dolor nesciunt ipsum, reiciendis quos corrupti ullam, hic maxime, eos fuga tempore tenetur nostrum tempora. Eligendi ducimus laudantium, aliquam dolore quam ipsa!"
        }]
      }
    )
  }

  ngOnDestroy(){
    this.activatedRouteSub.unsubscribe();
  }
}
