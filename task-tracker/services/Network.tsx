import axios, { AxiosInstance, AxiosResponse } from 'axios';
import { siteConfig } from "@/config/site";

export class Network {
    baseUrl: string = siteConfig.backend_url;
    axiosInstance: AxiosInstance;

    constructor() {
        this.axiosInstance = axios.create({
            baseURL: this.baseUrl,
            headers: {
                'Content-Type': 'application/json',
                'Access-Control-Allow-Origin' : '*',
                'Access-Control-Allow-Methods':'GET,PUT,POST,DELETE,PATCH,OPTIONS',
                "Access-Control-Allow-Headers": "Origin, Content-Type, X-Auth-Token, Authorization, Accept,charset,boundary,Content-Length",
                'Access-Control-Allow-Credentials':true,
            },
        });
    }

    async post(endpoint: string, data: any) {
        try {
            const response: AxiosResponse = await this.axiosInstance.post(endpoint, data);
            return response.data;
        } catch (error) {
            throw error;
        }
    }

    async get(endpoint: string) {
        try {
            const response: AxiosResponse = await this.axiosInstance.get(endpoint);
            console.log(response);
            return response.data;
        } catch (error) {
            throw error;
        }
    }

    async put(endpoint: string, data: any) {
        try {
            const response: AxiosResponse = await this.axiosInstance.put(endpoint, data);
            return response.data;
        } catch (error) {
            throw error;
        }
    }

    async delete(endpoint: string) {
        try {
            const response: AxiosResponse = await this.axiosInstance.delete(endpoint);
            return response.data;
        } catch (error) {
            throw error;
        }
    }
}
