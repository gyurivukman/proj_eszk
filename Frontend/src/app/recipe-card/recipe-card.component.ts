import {Component, Input, OnInit} from '@angular/core';
import { RecipeCard } from '../shared/recipe-card.model';

@Component({
  selector: 'app-recipe-card',
  templateUrl: './recipe-card.component.html',
  styleUrls: ['./recipe-card.component.css']
})
export class RecipeCardComponent implements OnInit {
  @Input() card: RecipeCard;

  constructor() { }

  ngOnInit() {
    this.card.title = this.card.title.substr(0,27)+"...";
    this.card.text = this.card.text.substr(0,70)+"...";
  }

}
