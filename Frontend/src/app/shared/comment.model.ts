import { User } from "./user.model";

export interface Comment{
    id?:number;
    user:User;
    created_at:String;
    order:number;
    text:string;
}