import { User } from "./user.model";

export class Comment{
    public id:number;
    public user:User;
    public creation_time:Date;
    public text:string;
}