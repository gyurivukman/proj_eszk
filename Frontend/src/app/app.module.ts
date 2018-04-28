import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { ShopComponent } from './shop/shop.component';
import { RecipeComponent } from './recipe/recipe.component';
import {AppRoutingModule} from './app-routing.module';
import { FeaturedRecipesSliderComponent } from './featured-recipes-slider/featured-recipes-slider.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    ShopComponent,
    RecipeComponent,
    FeaturedRecipesSliderComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
