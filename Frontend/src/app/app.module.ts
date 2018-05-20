import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule} from '@angular/http'

import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { ShopComponent } from './shop/shop.component';
import { AppRoutingModule } from './app-routing.module';
import { FeaturedRecipesSliderComponent } from './featured-recipes-slider/featured-recipes-slider.component';
import { RecipeCardComponent } from './recipe-card/recipe-card.component'
import { RecipeDetailComponent } from './recipe-detail/recipe-detail.component';
import { LoginComponent } from './login/login.component';
import { SignupComponent } from './signup/signup.component';
import { FridgeComponent } from './fridge/fridge.component';
import { RecipesComponent } from './recipes/recipes.component';
import { RouterModule } from '@angular/router';
import { CommentComponent } from './recipe-detail/comment/comment.component';
import { AuthModule } from './auth.module';
import { LoginService } from './login/login.service';
import { SignupService } from './signup/signup.service';
import { KeysPipe } from './shared/keypipe.pipe';
import { AccountComponent } from './account/account.component';
import { MyrecipesComponent } from './myrecipes/myrecipes.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    ShopComponent,
    FeaturedRecipesSliderComponent,
    RecipeCardComponent,
    RecipeDetailComponent,
    LoginComponent,
    SignupComponent,
    FridgeComponent,
    RecipesComponent,
    CommentComponent,
    KeysPipe,
    AccountComponent,
    MyrecipesComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    RouterModule,
    FormsModule,
    AuthModule
  ],
  providers: [
    LoginService,
    SignupService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
