import {Preparation} from "./preparation.model";
import {Ingredient} from "./ingredient.model";
import { User } from "./user.model";

export class Recipe {
  public id:number;
  public name:string;
  public description:string;
  public imgPath?:string; //string for now,bytearray otherwise.
  public ingredients: Ingredient[];
  public steps:Preparation[];
  public rating:number;
  public tags?:string[];
  public creator:User;
  public comments?:Comment[];
  public readyIn:number;
  public difficulty:string;
  public createdAt:string;
}
