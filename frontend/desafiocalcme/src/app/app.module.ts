import { AuthInterceptorProvider } from './interceptors/auth-iterceptor';
import { AuthService } from './../services/auth.services';
import { StorageService } from './../services/storage.service';
import { LoginComponent } from './views/login/login.component';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './views/home/home.component';
import { CadastroLoginComponent } from './views/cadastro-login/cadastro-login.component';
import { UsuarioService } from 'src/services/domain/usuario.service';
import { ClienteService } from 'src/services/domain/cliente.service';


@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    LoginComponent,
    CadastroLoginComponent,
    
    
  ],
  imports: [
    BrowserModule,
    ReactiveFormsModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    RouterModule,
    CommonModule,
    
    
    
  ],
  providers: [
    AuthService,
    StorageService,
    UsuarioService,
    ClienteService,
    AuthInterceptorProvider

  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
