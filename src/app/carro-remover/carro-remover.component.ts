import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Observable } from 'rxjs/internal/Observable';
import { UsuarioService } from '../_shared/service/usuario.service';

@Component({
  selector: 'app-carro-remover',
  templateUrl: './carro-remover.component.html',
  styleUrl: './carro-remover.component.scss'
})
export class CarroRemoverComponent implements OnInit {

  removerCarroRespostaUsuarioId: boolean = false;
  respostaRemoveCarroUsuarioPorId: any;
  idCarro: any;

  ngOnInit(): void {
    
  }

  constructor(private usuarioService: UsuarioService){}

  removerCarroDoUsuario(): Observable<any>{
   
    this.usuarioService.removerCarroDoUsuario(this.idCarro).subscribe({
      next: (data: any) => {
        this.respostaRemoveCarroUsuarioPorId = JSON.stringify(data, undefined, 2);
      },
      error: (httpError: HttpErrorResponse) => {
        this.respostaRemoveCarroUsuarioPorId = JSON.stringify(httpError.error, undefined, 2);
      }
    });

    this.removerCarroRespostaUsuarioId = true;
    
    return this.respostaRemoveCarroUsuarioPorId;
  }

  hidePanel(){
    this.removerCarroRespostaUsuarioId = false;
  }

  clearAllFields(removerCarroIdForm: NgForm){
    removerCarroIdForm.resetForm();
    this.removerCarroRespostaUsuarioId = false;
  }

}
