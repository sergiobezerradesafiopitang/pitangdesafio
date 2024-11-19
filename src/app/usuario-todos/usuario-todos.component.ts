import { Component, OnInit } from '@angular/core';
import { UsuarioService } from '../_shared/service/usuario.service';
import { Observable } from 'rxjs/internal/Observable';
import { NgForm } from '@angular/forms';
import { HttpErrorResponse } from '@angular/common/http';

@Component({
  selector: 'app-usuario-todos',
  templateUrl: './usuario-todos.component.html',
  styleUrl: './usuario-todos.component.scss'
})
export class UsuarioTodosComponent implements OnInit {

  todosUsuarios: boolean = false;
  respostaTodosUsuarios: any;

  ngOnInit(): void {
    
  }

  constructor(private usuarioService: UsuarioService){}

  listarTodosUsuarios(): Observable<any>{
   
    this.usuarioService.listarTodosUsuarios().subscribe({
      next: (data: any) => {
        this.respostaTodosUsuarios = JSON.stringify(data, undefined, 2);
      },
      error: (httpError: HttpErrorResponse) => {
        this.respostaTodosUsuarios = JSON.stringify(httpError.error, undefined, 2);
      }
    });

    this.todosUsuarios = true;
    
    return this.respostaTodosUsuarios;
  }

  hidePanel(){
    this.todosUsuarios = false;
  }

  clearAllFields(todosUsuariosForm: NgForm){
    todosUsuariosForm.resetForm();
    this.todosUsuarios = false;
  }

}
