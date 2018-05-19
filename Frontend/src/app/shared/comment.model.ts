import { User } from "./user.model";

export interface Comment{
    id?:number;
    user:User;
    creation_time:String;
    order:number;
    text:string;
}