import { NgModule } from '@angular/core';
import { RequestOptions, HttpModule, Http} from '@angular/http';
import { AuthHttp, AuthConfig, JwtHelper } from 'angular2-jwt';

export function authHttpServiceFactory(http: Http, options: RequestOptions){
    return new AuthHttp(new AuthConfig({
          tokenName: 'token',
          tokenGetter: (() => sessionStorage.getItem('token')),
          globalHeaders: [{'Content-Type':'application/json'}],
      }), http, options);
  }

@NgModule({
    imports:[
        HttpModule
    ],
  providers: [
      HttpModule,
      JwtHelper,
    {
      provide: AuthHttp,
      useFactory: authHttpServiceFactory,
      deps: [Http,RequestOptions]
    }
  ]
})
export class AuthModule {}
