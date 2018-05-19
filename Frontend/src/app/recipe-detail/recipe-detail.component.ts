import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Subscription } from 'rxjs/Subscription';
import { Recipe } from '../shared/recipe.model';
import { Ingredient } from '../shared/ingredient.model';
import { Comment } from '../shared/comment.model'

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
  constructor(private route:ActivatedRoute) {
    
  }

  addComment(){
    this.commentData.push(
      {
        user:{
              username:"LOGGED_IN_USER", 
              avatar:"http://i0.kym-cdn.com/photos/images/newsfeed/000/869/487/ccf.png"
            },
        created_at:new Date().toLocaleDateString(),
        order:this.commentData[this.commentData.length-1].order+1,
        text:this.userComment.trim()
      }
    )
    this.userComment="";
  }

  ngOnInit() {
    this.activatedRouteSub=this.route.params.subscribe(
      (params)=>{
        this.recipeData = {
          id:Number(params['recipeid']),
          name:"Szuper Duper Palacsinta Deluxe",
          description:"Lent voltunk vidéken aztán ez volt.The end.",
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
          user:{
            username:"CREATOR_1", 
            avatar:"http://i0.kym-cdn.com/photos/images/newsfeed/000/869/487/ccf.png"
          },
          created_at:"2018-05-20",
          order:1,
          text:"Lorem ipsum, dolor sit amet consectetur adipisicing elit. Dolor nesciunt ipsum, reiciendis quos corrupti ullam, hic maxime, eos fuga tempore tenetur nostrum tempora. Eligendi ducimus laudantium, aliquam dolore quam ipsa!Lorem ipsum, dolor sit amet consectetur adipisicing elit. Dolor nesciunt ipsum, reiciendis quos corrupti ullam, hic maxime, eos fuga tempore tenetur nostrum tempora. Eligendi ducimus laudantium, aliquam dolore quam ipsa!Lorem ipsum, dolor sit amet consectetur adipisicing elit. Dolor nesciunt ipsum, reiciendis quos corrupti ullam, hic maxime, eos fuga tempore tenetur nostrum tempora. Eligendi ducimus laudantium, aliquam dolore quam ipsa!"
        },{
          user:{
            username:"CREATOR_2", 
            avatar:"http://i0.kym-cdn.com/photos/images/newsfeed/000/869/487/ccf.png"
          },
         
          order:2,
          created_at:"2018-05-21",
          text:"Lorem ipsum, dolor sit amet consectetur adipisicing elit. Dolor nesciunt ipsum, reiciendis quos corrupti ullam, hic maxime, eos fuga tempore tenetur nostrum tempora. Eligendi ducimus laudantium, aliquam dolore quam ipsa!"
        },{
          user:{
            username:"CREATOR_1", 
            avatar:"http://i0.kym-cdn.com/photos/images/newsfeed/000/869/487/ccf.png"
          },
          
          order:3,
          created_at:"2018-05-22",
          text:"Lorem ipsum, dolor sit amet consectetur adipisicing elit. Dolor nesciunt ipsum, reiciendis quos corrupti ullam, hic maxime, eos fuga tempore tenetur nostrum tempora. Eligendi ducimus laudantium, aliquam dolore quam ipsa!"
        }]
      }
    )
  }

  isUserCommentInvalid(){
    return this.userComment == null || this.userComment.length<1 || !(/\S/.test(this.userComment))
  }
  ngOnDestroy(){
    this.activatedRouteSub.unsubscribe();
  }
}
