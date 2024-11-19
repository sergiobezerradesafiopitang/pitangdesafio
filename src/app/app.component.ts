import { Component, inject} from '@angular/core';
import { UsuarioService } from './_shared/service/usuario.service';
import { HttpClient } from '@angular/common/http';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss'
})
export class AppComponent {

  title = 'desafio-front';
  panelOpenState = false;
  respostaToken: string = "";
  

}
