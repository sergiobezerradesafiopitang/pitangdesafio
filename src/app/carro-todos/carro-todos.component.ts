import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Observable } from 'rxjs/internal/Observable';
import { UsuarioService } from '../_shared/service/usuario.service';

@Component({
  selector: 'app-carro-todos',
  templateUrl: './carro-todos.component.html',
  styleUrl: './carro-todos.component.scss'
})
export class CarroTodosComponent implements OnInit {

  todosCarros: boolean = false;
  respostaTodosCarros: any;

  ngOnInit(): void {
    
  }

  constructor(private usuarioService: UsuarioService){}

  listarTodosCarrosPorUsuario(): Observable<any>{
   
    this.usuarioService.listarTodosCarrosPorUsuario().subscribe({
      next: (data: any) => {
        this.respostaTodosCarros = JSON.stringify(data, undefined, 2);
      },
      error: (httpError: HttpErrorResponse) => {
        this.respostaTodosCarros = JSON.stringify(httpError.error, undefined, 2);
      }
    });

    this.todosCarros = true;
    
    return this.respostaTodosCarros;
  }

  hidePanel(){
    this.todosCarros = false;
  }

  clearAllFields(todosCarrosForm: NgForm){
    todosCarrosForm.resetForm();
    this.todosCarros = false;
  }


}
