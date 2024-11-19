import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Observable } from 'rxjs/internal/Observable';
import { UsuarioService } from '../_shared/service/usuario.service';

@Component({
  selector: 'app-carros-por-id',
  templateUrl: './carros-por-id.component.html',
  styleUrl: './carros-por-id.component.scss'
})
export class CarrosPorIdComponent implements OnInit {

  buscarRespostaCarroUsuarioId: boolean = false;
  respostaCarroUsuarioPorId: any;
  idCarro: any;

  ngOnInit(): void {
    
  }

  constructor(private usuarioService: UsuarioService){}

  buscarUmCarroDoUsuario(): Observable<any>{
   
    this.usuarioService.buscarUmCarroDoUsuario(this.idCarro).subscribe({
      next: (data: any) => {
        this.respostaCarroUsuarioPorId = JSON.stringify(data, undefined, 2);
      },
      error: (httpError: HttpErrorResponse) => {
        this.respostaCarroUsuarioPorId = JSON.stringify(httpError.error, undefined, 2);
      }
    });

    this.buscarRespostaCarroUsuarioId = true;
    
    return this.respostaCarroUsuarioPorId;
  }

  hidePanel(){
    this.buscarRespostaCarroUsuarioId = false;
  }

  clearAllFields(buscaCarroUsuarioIdForm: NgForm){
    buscaCarroUsuarioIdForm.resetForm();
    this.buscarRespostaCarroUsuarioId = false;
  }

}
