import { Component, OnInit, OnDestroy } from '@angular/core';
import { Subscription } from 'rxjs/Subscription';
import { ActivatedRoute } from '@angular/router';
import { RecipeCard } from '../shared/recipe-card.model';
import { Http } from '@angular/http';

@Component({
  selector: 'app-recipes',
  templateUrl: './recipes.component.html',
  styleUrls: ['./recipes.component.css']
})
export class RecipesComponent implements OnInit,OnDestroy{
  private sub:Subscription;
  private cards:RecipeCard[]=[]

  constructor(private route:ActivatedRoute,private http:Http){}

  ngOnInit(){
    this.sub = this.route.queryParams.subscribe(
      (param)=>{
        this.updateData(param);
      }
    )
    this.updateData({'id':1});
  }

  updateData(param:any){
    console.log(param)
    let endpoint:string = "/api/recipe/";
    let query:string;
    if('search' in param){  
      query="search?search="+param.search;
    }
    else if('tag' in param){

      query="tag?tag="+param.tag;

    }else if('id' in param){
      query="?id="+param.id;
    }
    this.http.post("/api/recipe/"+query,null).toPromise().then(
      (res)=>{
        this.cards=[]
        console.log(res.json())
        this.cards=res.json()
      }
    ).catch(
      (res)=>{
        this.cards=[]
      }
    )
  }

  ngOnDestroy(){
    this.sub.unsubscribe()
  }

  dummyCards = [
    {
      id: 1,
      title: 'Ez egy ciEz egy ciEz egy ciEz egy y ciEz egy ciEz egy ciEz egyy ciEz egy ciEz egy ciEz egyy ciEz egy ciEz egy ciEz egyciEz egy ciEz egy ciEz egy cim',
      text: 'Neque porro lor sit amet, consectetuer adipiscing elit. CurLorem ipsum dolor sit amet, consectetuelor sit amet, consectetuer adipiscing elit. CurLorem ipsum dolor sit amet, consectetuelor sit amet, consectetuer adipiscing elit. CurLorem ipsum dolor sit amet, consectetuelor sit amet, consectetuer adipiscing elit. CurLorem ipsum dolor sit amet, consectetue est qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit',
      imgUrl: 'https://i.imgur.com/bE4jFyr.jpg'
    }]
  
}
