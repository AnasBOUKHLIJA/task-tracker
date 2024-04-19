import { Task } from "./Task";

export interface BugTask extends Task {
    severity: string;
    stepsToReproduce: string;
}