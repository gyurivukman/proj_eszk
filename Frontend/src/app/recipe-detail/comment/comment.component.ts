import { Component, OnInit, Input } from '@angular/core';
import {Comment} from '../../shared/comment.model'

@Component({
  selector: 'app-comment',
  templateUrl: './comment.component.html',
  styleUrls: ['./comment.component.css']
})
export class CommentComponent implements OnInit {

  @Input('data')
  data:Comment;

  constructor() { }

  ngOnInit() {
  }

}
