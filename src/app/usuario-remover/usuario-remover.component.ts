import { Component, OnInit } from '@angular/core';
import { UsuarioService } from '../_shared/service/usuario.service';
import { Observable } from 'rxjs/internal/Observable';
import { HttpErrorResponse } from '@angular/common/http';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-usuario-remover',
  templateUrl: './usuario-remover.component.html',
  styleUrl: './usuario-remover.component.scss'
})
export class UsuarioRemoverComponent implements OnInit {

  removerRespostaUsuarioId: boolean = false;
  respostaRemoveUsuarioPorId: any;
  idUsuario: any;

  ngOnInit(): void {
    
  }

  constructor(private usuarioService: UsuarioService){}

  removeUsuarioPorId(): Observable<any>{
   
    this.usuarioService.removeUsuarioPorId(this.idUsuario).subscribe({
      next: (data: any) => {
        this.respostaRemoveUsuarioPorId = JSON.stringify(data, undefined, 2);
      },
      error: (httpError: HttpErrorResponse) => {
        this.respostaRemoveUsuarioPorId = JSON.stringify(httpError.error, undefined, 2);
      }
    });

    this.removerRespostaUsuarioId = true;
    
    return this.respostaRemoveUsuarioPorId;
  }

  hidePanel(){
    this.removerRespostaUsuarioId = false;
  }

  clearAllFields(removerUsuarioIdForm: NgForm){
    removerUsuarioIdForm.resetForm();
    this.removerRespostaUsuarioId = false;
  }

}
