import { Project } from "./Project";
import { User } from "./User";

export interface Task {
    id: number;
    name: string;
    description: string;
    status: string;
    createdAt: Date;
    assignedTo: User;
    project: Project;
}