import { NgModule, Injectable } from '@angular/core';
import { RequestOptions, HttpModule, Http} from '@angular/http';
import { AuthHttp, AuthConfig, JwtHelper } from 'angular2-jwt';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, Router } from '@angular/router';

export function authHttpServiceFactory(http: Http, options: RequestOptions){
    return new AuthHttp(new AuthConfig({
          tokenName: 'token',
          tokenGetter: (() => localStorage.getItem('token')),
          globalHeaders: [{'Content-Type':'application/json'}],
      }), http, options);
  }
  
@Injectable()
export class AuthGuardService implements CanActivate  {
  constructor(private jwthelper:JwtHelper,private router:Router){}
  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): boolean {
    if(this.isUserLoggedIn()){
      return true;
    }else{
      this.router.navigate(['/recipes'])
      return false;
    }
  }

  isUserLoggedIn():boolean{
    let token = localStorage.getItem("token");
    return token!=null && !this.jwthelper.isTokenExpired(token);
  }
} 

@NgModule({
    imports:[
        HttpModule
    ],
  providers: [
      HttpModule,
      JwtHelper,
      AuthGuardService,
    {
      provide: AuthHttp,
      useFactory: authHttpServiceFactory,
      deps: [Http,RequestOptions]
    }
  ]
})
export class AuthModule {}
