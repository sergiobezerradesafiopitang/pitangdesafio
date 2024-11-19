import { Component, OnInit } from '@angular/core';
import { UsuarioService } from '../_shared/service/usuario.service';
import { NgForm } from '@angular/forms';
import { HttpErrorResponse } from '@angular/common/http';
import { Observable } from 'rxjs/internal/Observable';
import { UsuarioDto } from '../model/dto/usuarioDto';
import { CarroDto } from '../model/dto/carroDto';

@Component({
  selector: 'app-usuario-cadastro',
  templateUrl: './usuario-cadastro.component.html',
  styleUrl: './usuario-cadastro.component.scss'
})
export class UsuarioCadastroComponent implements OnInit{

  
  cadastraUsuario: boolean = false;
  usuarioDto: any = new UsuarioDto();
  carroDto: any = new CarroDto();
  respostaCadastro: any;

  ngOnInit(): void {
   
  }

  constructor(private usuarioService: UsuarioService){}


  cadastrarUsuario(): Observable<any>{

    this.usuarioDto.cars[0] = this.carroDto;

    this.usuarioService.cadastraUsuario(this.usuarioDto).subscribe({
      next: (data: any) => {
        this.respostaCadastro = JSON.stringify(data, undefined, 2);
      },
      error: (httpError: HttpErrorResponse) => {
        this.respostaCadastro = JSON.stringify(httpError.error, undefined, 2);
      }
    });

    this.cadastraUsuario = true;

    
    return this.respostaCadastro;
  }

  hidePanel(){
    this.cadastraUsuario = false;
  }

  clearAllFields(cadastroUsuarioForm: NgForm){
    cadastroUsuarioForm.resetForm();
    this.cadastraUsuario = false;
  }

}
