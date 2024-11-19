import { Component, OnInit } from '@angular/core';
import { UsuarioService } from '../_shared/service/usuario.service';
import { Observable } from 'rxjs/internal/Observable';
import { HttpErrorResponse } from '@angular/common/http';
import { NgForm } from '@angular/forms';
import { CarroDto } from '../model/dto/carroDto';

@Component({
  selector: 'app-carro-cadastro',
  templateUrl: './carro-cadastro.component.html',
  styleUrl: './carro-cadastro.component.scss'
})
export class CarroCadastroComponent implements OnInit {

  cadastroCarro: boolean = false;
  carroCadastroResposta: any;
  carroDto: any = new CarroDto();

  ngOnInit(): void {
    
  }

  constructor(private usuarioService: UsuarioService){}

  cadastraCarroPorUsuario(): Observable<any>{
   
    this.usuarioService.cadastraCarroPorUsuario(this.carroDto).subscribe({
      next: (data: any) => {
        this.carroCadastroResposta = JSON.stringify(data, undefined, 2);
      },
      error: (httpError: HttpErrorResponse) => {
        this.carroCadastroResposta = JSON.stringify(httpError.error, undefined, 2);
      }
    });

    this.cadastroCarro = true;
    
    return this.carroCadastroResposta;
  }

  hidePanel(){
    this.cadastroCarro = false;
  }

  clearAllFields(cadastroCarroForm: NgForm){
    cadastroCarroForm.resetForm();
    this.cadastroCarro = false;
  }

}
