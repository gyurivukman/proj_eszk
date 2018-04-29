import { Component, OnInit } from '@angular/core';
import { FormGroup } from '@angular/forms';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  dummyCards = [
    {
      title: 'Ez egy ciEz egy ciEz egy ciEz egy y ciEz egy ciEz egy ciEz egyy ciEz egy ciEz egy ciEz egyy ciEz egy ciEz egy ciEz egyciEz egy ciEz egy ciEz egy cim',
      text: 'Neque porro lor sit amet, consectetuer adipiscing elit. CurLorem ipsum dolor sit amet, consectetuelor sit amet, consectetuer adipiscing elit. CurLorem ipsum dolor sit amet, consectetuelor sit amet, consectetuer adipiscing elit. CurLorem ipsum dolor sit amet, consectetuelor sit amet, consectetuer adipiscing elit. CurLorem ipsum dolor sit amet, consectetue est qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit',
      imgUrl: 'https://i.imgur.com/bE4jFyr.jpg'
    },
    {
      title: 'Ez egy másik nagyon gerely cim',
      text: 'Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Curabitur non augue et nisi porttitor pretium.',
      imgUrl: 'https://i.imgur.com/yDD0LCR.jpg'
    },
    {
      title: 'Hova tetted az overálomat?',
      text: 'Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Curabitur non augue et nisi porttitor pretium.',
      imgUrl: 'https://i.imgur.com/b0awqEb.jpg'
    },
    {
      title: 'Ez egy cim',
      text: 'Neque porro quisquam est qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit',
      imgUrl: 'https://i.imgur.com/bE4jFyr.jpg'
    },
    {
      title: 'Ez egy másik nagyon gerely cim',
      text: 'Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Curabitur non augue et nisi porttitor pretium.',
      imgUrl: 'https://i.imgur.com/yDD0LCR.jpg'
    },
    {
      title: 'Hova tetted az overálomat?',
      text: 'Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Curabitur non augue et nisi porttitor pretium.',
      imgUrl: 'https://i.imgur.com/b0awqEb.jpg'
    },
    {
      title: 'Ez egy cim',
      text: 'Neque porro quisquam est qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit',
      imgUrl: 'https://i.imgur.com/bE4jFyr.jpg'
    },
    {
      title: 'Ez egy másik nagyon gerely cim',
      text: 'Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Curabitur non augue et nisi porttitor pretium.',
      imgUrl: 'https://i.imgur.com/yDD0LCR.jpg'
    },
    {
      title: 'Hova tetted az overálomat?',
      text: 'Lorem ipsum dolor sit amet, consectetuer adipiscing elit. CurLorem ipsum dolor sit amet, consectetuer adipiscing elit. CurLorem ipsum dolor sit amet, consectetuer adipiscing elit. CurLoremLorem ipsum dolor sit amet, consectetuer adipiscing elit. CurLorem ipsum dolor sit amet, consectetuer adipiscing elit. CurLorem ipsum dolor sit amet, consectetuer adipiscing elit. CurLorem ipsum dolor sit amet, consectetuer adipiscing elit. CurLorem ipsum dolor sit amet, consectetuer adipiscing elit. CurLorem ipsum dolor sit amet, consectetuer adipiscing elit. Cur ipsum dolor sit amet, consectetuer adipiscing elit. CurLorem ipsum dolor sit amet, consectetuer adipiscing elit. CurLorem ipsum dolor sit amet, consectetuer adipiscing elit. Curabitur non augue et nisi porttitor pretium.',
      imgUrl: 'https://i.imgur.com/b0awqEb.jpg'
    }
  ];

  constructor() { }

  ngOnInit() {}

  attemptLogin(loginForm:FormGroup){
    console.log(loginForm)
  }

  attemptSignup(signupForm:FormGroup){
    console.log(signupForm.value)
  }

}
