import { Component, OnInit, ViewChild, ElementRef } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { SignupService } from './signup.service';
import { SignUpData } from '../shared/signup-data.model';

@Component({
  selector: 'app-signup-modal',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {
  errors:SignUpData
  @ViewChild('closeSignup') closeSignup: ElementRef;
  constructor(private signupservice:SignupService) {}
  

  ngOnInit() {
  }

  attemptSignup(formGroup:FormGroup){
    this.signupservice.attemptSignup(formGroup.value).then(
      (res)=>{
        console.log("OK")
        console.log(res)
        this.closeSignup.nativeElement.click();
      }
    ).catch(
      (res)=>{
        console.log("elbaszódott")
        console.log(res.json())
        let errors = res.json()
        for(let key in this.errors){
          if(errors.hasOwnProperty(key)){
            this.errors[key]=errors[key];
          }
        }
      }
    )
  }
}
