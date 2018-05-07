import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { HomeComponent } from './home/home.component';
import { RecipeDetailComponent } from './recipe-detail/recipe-detail.component';
import { ShopComponent } from './shop/shop.component';
import { RecipesComponent } from './recipes/recipes.component';

const appRoutes: Routes = [
  { path:'', redirectTo:'recipes',pathMatch:'full' },
  { path:'recipes',component:RecipesComponent,pathMatch:'prefix' },
  { path:'shop',component:ShopComponent,pathMatch:'prefix' },
  { path: 'recipes/:recipeid', component:RecipeDetailComponent,pathMatch:'full'},
];

@NgModule({
  imports: [
    RouterModule.forRoot(appRoutes)
  ],
  exports: [RouterModule]
})
export class AppRoutingModule {

}
