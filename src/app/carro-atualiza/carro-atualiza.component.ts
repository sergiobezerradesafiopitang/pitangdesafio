import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Observable } from 'rxjs/internal/Observable';
import { UsuarioService } from '../_shared/service/usuario.service';
import { CarroDto } from '../model/dto/carroDto';

@Component({
  selector: 'app-carro-atualiza',
  templateUrl: './carro-atualiza.component.html',
  styleUrl: './carro-atualiza.component.scss'
})
export class CarroAtualizaComponent implements OnInit {

  atualizaCarro: boolean = false;
  carroCadastroResposta: any;
  carroDto: any = new CarroDto();

  ngOnInit(): void {
    
  }

  constructor(private usuarioService: UsuarioService){}

  atualizarCarroDoUsuario(): Observable<any>{
   
    this.usuarioService.atualizarCarroDoUsuario(this.carroDto).subscribe({
      next: (data: any) => {
        this.carroCadastroResposta = JSON.stringify(data, undefined, 2);
      },
      error: (httpError: HttpErrorResponse) => {
        this.carroCadastroResposta = JSON.stringify(httpError.error, undefined, 2);
      }
    });

    this.atualizaCarro = true;
    
    return this.carroCadastroResposta;
  }

  hidePanel(){
    this.atualizaCarro = false;
  }

  clearAllFields(atualizaCarroForm: NgForm){
    atualizaCarroForm.resetForm();
    this.atualizaCarro = false;
  }


}
