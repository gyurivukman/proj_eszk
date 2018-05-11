import { Component, OnInit } from '@angular/core';
import { FeaturedRecipe } from '../shared/featured-recipes.model';

@Component({
  selector: 'app-featured-recipes-slider',
  templateUrl: './featured-recipes-slider.component.html',
  styleUrls: ['./featured-recipes-slider.component.css']
})
export class FeaturedRecipesSliderComponent implements OnInit {

  data:Array<FeaturedRecipe>=[
    {
      id:1,
      title:"title_1",
      description:"desc_1",
      image:"http://placekitten.com/800/400"
    },
    {
      id:2,
      title:"title_2",
      description:"desc_2",
      image:"http://placekitten.com/800/400"
    },
    {
      id:3,
      title:"title_3",
      description:"desc_3",
      image:"http://placekitten.com/800/400"
    },
    {
      id:4,
      title:"title_4",
      description:"desc_4",
      image:"http://placekitten.com/800/400"
    },
  ];
  constructor() { }

  ngOnInit() {
  }

}
