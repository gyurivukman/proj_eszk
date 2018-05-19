import { Recipe } from "./recipe.model";

export interface User{
    id?:number;
    username:string;
    surname?:string;
    forename?:string;
    email?:string;
    recipes?:Recipe[]
    comments?:Comment[]
    
    avatar?:any; //bytearray for image.this is tmp for now.
}