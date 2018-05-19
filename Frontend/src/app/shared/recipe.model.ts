import {Preparation} from "./preparation.model";
import {Ingredient} from "./ingredient.model";
import { User } from "./user.model";

export interface Recipe {
  id:number;
  name:string;
  description:string;
  imgPath?:string; //string for now,bytearray otherwise.
  ingredients: Ingredient[];
  steps:Preparation[];
  rating:number;
  tags?:string[];
  creator:User;
  comments?:Comment[];
  readyIn:number;
  difficulty:string;
  createdAt:string;
}
