import { UsuarioDTO } from './../../app/models/usuario.dto';
import { Injectable } from '@angular/core';
import { AuthService } from './../auth.services';
import { HttpClient } from '@angular/common/http';
import { StorageService } from '../storage.service';
import { API_CONFIG } from '../../app/config/api.config';

@Injectable()
export class UsuarioService {
    
    constructor(public http: HttpClient, public storage: StorageService,public auth: AuthService){    }

   
    findById(id: string) {
        return this.http.get(`${API_CONFIG.baseUrl}/usuarios/${id}`);
    }      


    insert(obj : UsuarioDTO) {
        return this.http.post(
            `${API_CONFIG.baseUrl}/usuarios`,
            obj,
            {
                observe: 'response',
                responseType: 'text'
            }
        );
    }
    

}