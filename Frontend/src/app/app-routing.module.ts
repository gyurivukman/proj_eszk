import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { HomeComponent } from './home/home.component';
import { RecipeDetailComponent } from './recipe-detail/recipe-detail.component';
import { ShopComponent } from './shop/shop.component';
import { RecipesComponent } from './recipes/recipes.component';
import { AuthGuardService } from './auth.module';
import { AccountComponent } from './account/account.component';
import { MyrecipesComponent } from './myrecipes/myrecipes.component';

const appRoutes: Routes = [
  { path:'', redirectTo:'recipes',pathMatch:'full' },
  { path:'recipes',component:RecipesComponent,pathMatch:'prefix' },
  { path:'shop',component:ShopComponent,pathMatch:'prefix',canActivate:[AuthGuardService]},
  { path:'account',component:AccountComponent,pathMatch:'prefix',canActivate:[AuthGuardService]},
  { path:'myrecipes',component:MyrecipesComponent,pathMatch:'prefix',canActivate:[AuthGuardService]},
  { path: 'recipes/:recipeid', component:RecipeDetailComponent,pathMatch:'full'},
  { path: '**',redirectTo:'recipes'}
];

@NgModule({
  imports: [
    RouterModule.forRoot(appRoutes)
  ],
  exports: [RouterModule]
})
export class AppRoutingModule {

}
