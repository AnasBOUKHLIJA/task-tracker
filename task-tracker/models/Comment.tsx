import { User } from "./User";
import { Task } from './Task';

export interface Comment {
    id: number
    content: string
    createdAt: Date;
    author: User;
    task: Task;
}