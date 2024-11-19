import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {MaterialModule} from './material/material.module'
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import { UsuarioService } from './_shared/service/usuario.service';
import { UsuarioTokenComponent } from './usuario-token/usuario-token.component';
import { provideHttpClient } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { UsuarioCadastroComponent } from './usuario-cadastro/usuario-cadastro.component';
import {MatDatepickerModule} from '@angular/material/datepicker';
import {MatInputModule} from '@angular/material/input';
import {MatFormFieldModule} from '@angular/material/form-field';
import {provideNativeDateAdapter} from '@angular/material/core';
import { UsuarioTodosComponent } from './usuario-todos/usuario-todos.component';
import { UsuarioPorIdComponent } from './usuario-por-id/usuario-por-id.component';
import { UsuarioAtualizaComponent } from './usuario-atualiza/usuario-atualiza.component';
import { UsuarioRemoverComponent } from './usuario-remover/usuario-remover.component';
import { CarroTodosComponent } from './carro-todos/carro-todos.component';
import { UsuarioInformacoesComponent } from './usuario-informacoes/usuario-informacoes.component';
import { CarroCadastroComponent } from './carro-cadastro/carro-cadastro.component';
import { CarrosTodosComponent } from './carros-todos/carros-todos.component';
import { CarrosPorIdComponent } from './carros-por-id/carros-por-id.component';
import { CarroAtualizaComponent } from './carro-atualiza/carro-atualiza.component';
import { CarroRemoverComponent } from './carro-remover/carro-remover.component';


@NgModule({
  declarations: [
    AppComponent,
    UsuarioTokenComponent,
    UsuarioCadastroComponent,
    UsuarioTodosComponent,
    UsuarioPorIdComponent,
    UsuarioAtualizaComponent,
    UsuarioRemoverComponent,
    CarroTodosComponent,
    UsuarioInformacoesComponent,
    CarroCadastroComponent,
    CarrosTodosComponent,
    CarrosPorIdComponent,
    CarroAtualizaComponent,
    CarroRemoverComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    MaterialModule,
    BrowserAnimationsModule,
    FormsModule,
    MatDatepickerModule,
    MatInputModule,
    MatFormFieldModule
  ],
  providers: [UsuarioService,  provideHttpClient(), provideNativeDateAdapter()],
  bootstrap: [AppComponent]
})
export class AppModule { }
