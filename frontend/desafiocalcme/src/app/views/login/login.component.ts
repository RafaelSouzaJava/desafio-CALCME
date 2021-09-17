import { AuthService } from './../../../services/auth.services';
import { Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';

import { CredenciaisDTO } from './../../models/credenciais.dto';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  creds: CredenciaisDTO = {
    login: "",
    senha: ""
  }

  constructor(private auth: AuthService, private router: Router) { }

  login(){
    this.auth.authenticate(this.creds)
    .subscribe(data => {
      this.auth.successfulLogin(data.headers.get('Authorization'));
      this.router.navigate(['home']);
    },
    error => {});
     
   }

  ngOnInit(): void {
    
  }

  

}
