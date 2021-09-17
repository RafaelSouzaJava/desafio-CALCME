import { Router } from '@angular/router';
import { ClienteService } from './../../../services/domain/cliente.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Component, OnInit } from '@angular/core';
import { StorageService } from 'src/services/storage.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  form: FormGroup;

  constructor(private clienteService: ClienteService,
    private formBuilder: FormBuilder, private storage: StorageService) {

    this.form = this.formBuilder.group({
      nome: ['', [Validators.required]],
      email: ['', [Validators.required, Validators.email]],
      telefone: ['', [Validators.required]]
    })
  }

  ngOnInit(): void {
  }

  salvarCliente() {
    let localUser = this.storage.getLocalUser();
    if (localUser  && localUser.token) {
      this.clienteService.insert(this.form.value).subscribe(data => {
        alert("Cliente cadastrado");
      })
    }
  }

}
