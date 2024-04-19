import { Task } from "./Task";

export interface FeatureTask extends Task {
    priority: string;
    acceptanceCriteria: string;
}