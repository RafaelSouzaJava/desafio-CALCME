import { AuthService } from './../auth.services';
import { StorageService } from './../storage.service';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { ClienteDTO } from '../../app/models/cliente.dto';
import { API_CONFIG } from '../../app/config/api.config';


@Injectable()
export class ClienteService {
    
    constructor(public http: HttpClient, public storage: StorageService,public auth: AuthService){    }

   
    findById(id: string) {
        return this.http.get(`${API_CONFIG.baseUrl}/clientes/${id}`);
    }      

    findAll() {
        return this.http.get(`${API_CONFIG.baseUrl}/clientes`);
    }     


    insert(obj : ClienteDTO) {
        return this.http.post(
            `${API_CONFIG.baseUrl}/clientes`,
            obj,
            {
                observe: 'response',
                responseType: 'text'
            }
        );
    }
}