import { LocalUser } from './../app/models/local_user';
import { API_CONFIG } from './../app/config/api.config';
import { CredenciaisDTO } from './../app/models/credenciais.dto';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';


import { StorageService } from './storage.service';
import { JwtHelperService } from '@auth0/angular-jwt';


@Injectable()
export class AuthService {
  [x: string]: any;

    jwtHelper: JwtHelperService = new JwtHelperService();

    constructor(public http: HttpClient,
         public storage: StorageService){        
    }

    authenticate(creds : CredenciaisDTO){
       return this.http.post(`${API_CONFIG.baseUrl}/login`,
        creds,
        {
            observe: 'response',
            responseType: 'text'
        })        
    }

    refreshToken(){
        return this.http.post(`${API_CONFIG.baseUrl}/auth/refresh_token`,
         {},
         {
             observe: 'response',
             responseType: 'text'
         })        
     }

    successfulLogin(authorizationValue : string){
        let tok = authorizationValue.substring(7);
        let user : LocalUser = {
            token: tok  
                         
        };       
        this.storage.setLocalUser(user);       
        
    }

    logaut() {
        this.storage.setLocalUser(null);
    }
}