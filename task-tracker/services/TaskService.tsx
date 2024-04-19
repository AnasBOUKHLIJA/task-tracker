import { Network } from './Network';


export class TaskService {
    
    static readonly network: Network = new Network();
    static readonly CONTROLLER_NAME: string = "/task";    

    static async createFeatureTask(data: any) {
        try {
            const response = await this.network.post(this.CONTROLLER_NAME + '/feature/create', data);
            return response;
        } catch (error) {
            throw error;
        }
    }


    static async createBugTask(data: any) {
        try {
            const response = await this.network.post(this.CONTROLLER_NAME + '/bug/create', data);
            return response;
        } catch (error) {
            throw error;
        }
    }


    static async getAllFeatureTasks() {
        try {
            const response = await this.network.get(this.CONTROLLER_NAME + '/feature/getAll');
            return response;
        } catch (error) {
            throw error;
        }
    }


    static async getAllBugTasks() {
        try {
            const response = await this.network.get(this.CONTROLLER_NAME + '/bug/getAll');
            return response;
        } catch (error) {
            throw error;
        }
    }

    static async getTaskById(id: number) {
        try {
            const response = await this.network.get(this.CONTROLLER_NAME + `/getById/${id}`);
            return response;
        } catch (error) {
            throw error;
        }
    }

    static async deleteTask(id: number) {
        try {
            const response = await this.network.delete(this.CONTROLLER_NAME + `/delete/${id}`);
            return response;
        } catch (error) {
            throw error;
        }
    }

    static async updateTask(id: number, data: any) {
        try {
            const response = await this.network.put(this.CONTROLLER_NAME + `/update/${id}`, data);
            return response;
        } catch (error) {
            throw error;
        }
    }
}
