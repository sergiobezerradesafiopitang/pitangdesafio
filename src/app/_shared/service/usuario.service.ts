import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs/internal/Observable';
import { LoginDto } from '../../model/dto/loginDto';
import { UsuarioDto } from '../../model/dto/usuarioDto';
import { CarroDto } from '../../model/dto/carroDto';


@Injectable({
  providedIn: 'root'
})
export class UsuarioService {

  private uriToken: string = "http://localhost:8082/v1/api/signin";
  private urlCadastroUsuario: string = "http://localhost:8082/v1/api/users";
  private urlTodosUsuarios: string = "http://localhost:8082/v1/api/users";
  private urlUsuariosPorId: string = "http://localhost:8082/v1/api/users";
  private urlAtualizaUsuariosPorId: string = "http://localhost:8082/v1/api/users";
  private urlRemoveUsuariosPorId: string = "http://localhost:8082/v1/api/users";
  private urlInformacoesUsuarios: string = "http://localhost:8082/v1/api/me";
  private urlCadastroCarro: string = "http://localhost:8082/v1/api/cars";
  private urlTodosCarro: string = "http://localhost:8082/v1/api/cars";
  private urlCarroUsuarioId: string = "http://localhost:8082/v1/api/cars";
  private urlAtualizaCarro: string = "http://localhost:8082/v1/api/cars";
  private urlRemoveCarro: string = "http://localhost:8082/v1/api/cars";



  constructor(public http: HttpClient) { }


  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
      
    })
  };

  getToken(loginDto: LoginDto): Observable<any> {
    return this.http.post<any>(this.uriToken, loginDto, this.httpOptions);
  }

  cadastraUsuario(usuarioDto: UsuarioDto): Observable<any>{
    return this.http.post<any>(this.urlCadastroUsuario, usuarioDto, this.httpOptions);
  }

  listarTodosUsuarios(): Observable<any>{
    return this.http.get<any>(this.urlTodosUsuarios, this.httpOptions);
  }

  buscaUsuarioPorId(idUsuario: string): Observable<any> {
    let finalUrl = this.urlUsuariosPorId + "/" + idUsuario;
    return this.http.get<any>(finalUrl, this.httpOptions);
  }

  atualizaUsuarioPorId(usuarioDto: UsuarioDto): Observable<any> {
    let finalUrl = this.urlAtualizaUsuariosPorId + "/" + usuarioDto.id_usuario;
    return this.http.put<any>(finalUrl, usuarioDto, this.httpOptions);
  }

  removeUsuarioPorId(idUsuario: string): Observable<any> {
    let finalUrl = this.urlRemoveUsuariosPorId + "/" + idUsuario;
    return this.http.delete<any>(finalUrl);
  }

  buscaInformacoesUsuario(loginDto: LoginDto): Observable<any> {
    console.log("Headers =>" + this.httpOptions.headers.get("access_token"));
    return this.http.post<any>(this.urlInformacoesUsuarios, loginDto, this.httpOptions);
  }

  cadastraCarroPorUsuario(carroDto: CarroDto): Observable<any> {
    return this.http.post<any>(this.urlCadastroCarro, carroDto, this.httpOptions);
  }

  listarTodosCarrosPorUsuario(): Observable<any> {
    return this.http.get<any>(this.urlTodosCarro, this.httpOptions);
  }

  buscarUmCarroDoUsuario(idCarro: string): Observable<any> {
    let finalUrl = this.urlCarroUsuarioId + "/" + idCarro;
    return this.http.get<any>(finalUrl, this.httpOptions);
  }

  atualizarCarroDoUsuario(carroDto: CarroDto): Observable<any> {
    let finalUrl = this.urlAtualizaCarro + "/" + carroDto.id_carro;
    return this.http.put<any>(finalUrl, carroDto, this.httpOptions);
  }

  removerCarroDoUsuario(idCarro: string): Observable<any> {
    let finalUrl = this.urlRemoveCarro + "/" + idCarro;
    return this.http.delete<any>(finalUrl);
  }


}
