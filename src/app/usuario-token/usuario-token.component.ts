import { Component, OnInit} from '@angular/core';
import { UsuarioService } from '../_shared/service/usuario.service';
import { LoginDto } from '../model/dto/loginDto';
import { Observable } from 'rxjs/internal/Observable';
import { HttpErrorResponse } from '@angular/common/http';
import { NgForm } from '@angular/forms';


@Component({
  selector: 'app-usuario-token',
  templateUrl: './usuario-token.component.html',
  styleUrl: './usuario-token.component.scss'
})
export class UsuarioTokenComponent implements OnInit {

  buscaTokenResultado: boolean = false;
  loginDto: LoginDto = new LoginDto();
  respostaToken: any;

  ngOnInit(): void {
   
  }

  constructor(private usuarioService: UsuarioService){}


  getToken(): Observable<any>{
   
    this.usuarioService.getToken(this.loginDto).subscribe({
      next: (data: any) => {
        this.respostaToken = JSON.stringify(data, undefined, 2);
      },
      error: (httpError: HttpErrorResponse) => {
        this.respostaToken = JSON.stringify(httpError.error, undefined, 2);
      }
    });

    this.buscaTokenResultado = true;
     
    return this.respostaToken;
  }

  hidePanel(){
    this.buscaTokenResultado = false;
  }

  clearAllFields(loginDtoForm: NgForm){
    loginDtoForm.resetForm();
    this.buscaTokenResultado = false;
  }
  

}
