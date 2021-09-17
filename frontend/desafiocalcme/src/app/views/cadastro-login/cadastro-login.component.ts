import { Router } from '@angular/router';
import { UsuarioService } from './../../../services/domain/usuario.service';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ThrowStmt } from '@angular/compiler';

@Component({
  selector: 'app-cadastro-login',
  templateUrl: './cadastro-login.component.html',
  styleUrls: ['./cadastro-login.component.css']
})
export class CadastroLoginComponent implements OnInit {

  form: FormGroup;

  constructor(private usuarioService: UsuarioService,
    private formBuilder: FormBuilder,
    private router: Router) {
    this.form = this.formBuilder.group({
      login: ['', [Validators.required]],
      senha: ['', [Validators.required]]
    })
  }

  ngOnInit(): void {
  }

  cadastar() {
    this.usuarioService.insert(this.form.value).subscribe(data => {      
      this.router.navigate(['']);
      alert("Usuario cadastrado");
    }, error => { });
  }





}
