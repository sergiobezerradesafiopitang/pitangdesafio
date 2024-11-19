import { Component, OnInit } from '@angular/core';
import { UsuarioService } from '../_shared/service/usuario.service';
import { Observable } from 'rxjs/internal/Observable';
import { HttpErrorResponse } from '@angular/common/http';
import { NgForm } from '@angular/forms';
import { UsuarioDto } from '../model/dto/usuarioDto';
import { CarroDto } from '../model/dto/carroDto';

@Component({
  selector: 'app-usuario-atualiza',
  templateUrl: './usuario-atualiza.component.html',
  styleUrl: './usuario-atualiza.component.scss'
})
export class UsuarioAtualizaComponent implements OnInit {

  atualizaRespostaUsuarioId: boolean = false;
  respostaAtualizaUsuarioPorId: any;
  usuarioDto: any = new UsuarioDto();
  carroDto: any = new CarroDto();

  ngOnInit(): void {
    
  }

  constructor(private usuarioService: UsuarioService){}

  atualizaUsuarioPorId(): Observable<any>{

    this.usuarioDto.cars[0] = this.carroDto;
   
    this.usuarioService.atualizaUsuarioPorId(this.usuarioDto).subscribe({
      next: (data: any) => {
        this.respostaAtualizaUsuarioPorId = JSON.stringify(data, undefined, 2);
      },
      error: (httpError: HttpErrorResponse) => {
        this.respostaAtualizaUsuarioPorId = JSON.stringify(httpError.error, undefined, 2);
      }
    });

    this.atualizaRespostaUsuarioId = true;
    
    return this.respostaAtualizaUsuarioPorId;
  }

  hidePanel(){
    this.atualizaRespostaUsuarioId = false;
  }

  clearAllFields(atualizaUsuarioIdForm: NgForm){
    atualizaUsuarioIdForm.resetForm();
    this.atualizaRespostaUsuarioId = false;
  }

}
