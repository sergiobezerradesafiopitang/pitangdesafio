import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { UsuarioService } from '../_shared/service/usuario.service';
import { Observable } from 'rxjs/internal/Observable';

@Component({
  selector: 'app-usuario-por-id',
  templateUrl: './usuario-por-id.component.html',
  styleUrl: './usuario-por-id.component.scss'
})
export class UsuarioPorIdComponent implements OnInit{

  buscarRespostaUsuarioId: boolean = false;
  respostaUsuarioPorId: any;
  idUsuario: any;

  ngOnInit(): void {
    
  }

  constructor(private usuarioService: UsuarioService){}

  buscaUsuarioPorId(): Observable<any>{
   
    this.usuarioService.buscaUsuarioPorId(this.idUsuario).subscribe({
      next: (data: any) => {
        this.respostaUsuarioPorId = JSON.stringify(data, undefined, 2);
      },
      error: (httpError: HttpErrorResponse) => {
        this.respostaUsuarioPorId = JSON.stringify(httpError.error, undefined, 2);
      }
    });

    this.buscarRespostaUsuarioId = true;
    
    return this.respostaUsuarioPorId;
  }

  hidePanel(){
    this.buscarRespostaUsuarioId = false;
  }

  clearAllFields(buscaUsuarioIdForm: NgForm){
    buscaUsuarioIdForm.resetForm();
    this.buscarRespostaUsuarioId = false;
  }

}
