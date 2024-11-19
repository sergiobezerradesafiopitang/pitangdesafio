import { Component, OnInit } from '@angular/core';
import { LoginDto } from '../model/dto/loginDto';
import { UsuarioService } from '../_shared/service/usuario.service';
import { Observable } from 'rxjs/internal/Observable';
import { HttpErrorResponse } from '@angular/common/http';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-usuario-informacoes',
  templateUrl: './usuario-informacoes.component.html',
  styleUrl: './usuario-informacoes.component.scss'
})
export class UsuarioInformacoesComponent implements OnInit {

  informacoesResultado: boolean = false;
  loginDto: LoginDto = new LoginDto();
  respostaInformacoes: any;

  ngOnInit(): void {
   
  }

  constructor(private usuarioService: UsuarioService){}


  buscaInformacoesUsuario(): Observable<any>{
   
    this.usuarioService.buscaInformacoesUsuario(this.loginDto).subscribe({
      next: (data: any) => {
        this.respostaInformacoes = JSON.stringify(data, undefined, 2);
      },
      error: (httpError: HttpErrorResponse) => {
        this.respostaInformacoes = JSON.stringify(httpError.error, undefined, 2);
      }
    });

    this.informacoesResultado = true;
    
    return this.respostaInformacoes;
  }

  hidePanel(){
    this.informacoesResultado = false;
  }

  clearAllFields(informacoesLoginDtoForm: NgForm){
    informacoesLoginDtoForm.resetForm();
    this.informacoesResultado = false;
  }


}
