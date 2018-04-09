import {Preparation} from "./preparation.model";
import {Ingredient} from "./ingredient.model";

export class Recipe {
  public name: string;
  public imgPath: string;
  public videoPath: string;
  public ingredients: Ingredient[];
  public steps: Preparation[];
}
