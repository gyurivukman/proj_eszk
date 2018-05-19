import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-recipes',
  templateUrl: './recipes.component.html',
  styleUrls: ['./recipes.component.css']
})
export class RecipesComponent implements OnInit {
  dummyCards = [
    {
      id: 1,
      title: 'Ez egy ciEz egy ciEz egy ciEz egy y ciEz egy ciEz egy ciEz egyy ciEz egy ciEz egy ciEz egyy ciEz egy ciEz egy ciEz egyciEz egy ciEz egy ciEz egy cim',
      text: 'Neque porro lor sit amet, consectetuer adipiscing elit. CurLorem ipsum dolor sit amet, consectetuelor sit amet, consectetuer adipiscing elit. CurLorem ipsum dolor sit amet, consectetuelor sit amet, consectetuer adipiscing elit. CurLorem ipsum dolor sit amet, consectetuelor sit amet, consectetuer adipiscing elit. CurLorem ipsum dolor sit amet, consectetue est qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit',
      imgUrl: 'https://i.imgur.com/bE4jFyr.jpg'
    },
    {
      id: 2,
      title: 'Ez egy másik nagyon gerely cim',
      text: 'Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Curabitur non augue et nisi porttitor pretium.',
      imgUrl: 'https://i.imgur.com/yDD0LCR.jpg'
    },
    {
      id: 3,
      title: 'Hova tetted az overálomat?',
      text: 'Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Curabitur non augue et nisi porttitor pretium.',
      imgUrl: 'https://i.imgur.com/b0awqEb.jpg'
    },
    {
      id: 4,
      title: 'Ez egy cim',
      text: 'Neque porro quisquam est qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit',
      imgUrl: 'https://i.imgur.com/bE4jFyr.jpg'
    },
    {
      id: 5,
      title: 'Ez egy másik nagyon gerely cim',
      text: 'Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Curabitur non augue et nisi porttitor pretium.',
      imgUrl: 'https://i.imgur.com/yDD0LCR.jpg'
    },
    {
      id: 6,
      title: 'Hova tetted az overálomat?',
      text: 'Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Curabitur non augue et nisi porttitor pretium.',
      imgUrl: 'https://i.imgur.com/b0awqEb.jpg'
    },
    {
      id: 7,
      title: 'Ez egy cim',
      text: 'Neque porro quisquam est qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit',
      imgUrl: 'https://i.imgur.com/bE4jFyr.jpg'
    },
    {
      id: 8,
      title: 'Ez egy másik nagyon gerely cim',
      text: 'Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Curabitur non augue et nisi porttitor pretium.',
      imgUrl: 'https://i.imgur.com/yDD0LCR.jpg'
    },
    {
      id: 9,
      title: 'Hova tetted az overálomat?',
      text: 'Lorem ipsum dolor sit amet, consectetuer adipiscing elit. CurLorem ipsum dolor sit amet, consectetuer adipiscing elit. CurLorem ipsum dolor sit amet, consectetuer adipiscing elit. CurLoremLorem ipsum dolor sit amet, consectetuer adipiscing elit. CurLorem ipsum dolor sit amet, consectetuer adipiscing elit. CurLorem ipsum dolor sit amet, consectetuer adipiscing elit. CurLorem ipsum dolor sit amet, consectetuer adipiscing elit. CurLorem ipsum dolor sit amet, consectetuer adipiscing elit. CurLorem ipsum dolor sit amet, consectetuer adipiscing elit. Cur ipsum dolor sit amet, consectetuer adipiscing elit. CurLorem ipsum dolor sit amet, consectetuer adipiscing elit. CurLorem ipsum dolor sit amet, consectetuer adipiscing elit. Curabitur non augue et nisi porttitor pretium.',
      imgUrl: 'https://i.imgur.com/b0awqEb.jpg'
    }
  ];
  constructor() { }

  ngOnInit() {
  }

}