import { User } from "./user.model";

export interface Comment{
    id?:number;
    username:string
    user_id:number;
    createdAt:String;
    order:number;
    text:string;
}