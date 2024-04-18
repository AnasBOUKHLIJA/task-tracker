import { Network } from './Network';


export class ProjectService {
    
    static readonly network: Network = new Network();
    static readonly CONTROLLER_NAME: string = "/project";    

    static async createProject(data: any) {
        try {
            const response = await this.network.post(this.CONTROLLER_NAME + '/create', data);
            return response;
        } catch (error) {
            throw error;
        }
    }

    static async getAllProjects() {
        try {
            const response = await this.network.get(this.CONTROLLER_NAME + '/getAll');
            return response;
        } catch (error) {
            throw error;
        }
    }

    static async getProjectById(id: number) {
        try {
            const response = await this.network.get(this.CONTROLLER_NAME + `/getById/${id}`);
            return response;
        } catch (error) {
            throw error;
        }
    }

    static async deleteProject(id: number) {
        try {
            const response = await this.network.delete(this.CONTROLLER_NAME + `/delete/${id}`);
            return response;
        } catch (error) {
            throw error;
        }
    }

    static async updateProject(id: number, data: any) {
        try {
            const response = await this.network.put(this.CONTROLLER_NAME + `/update/${id}`, data);
            return response;
        } catch (error) {
            throw error;
        }
    }
}
