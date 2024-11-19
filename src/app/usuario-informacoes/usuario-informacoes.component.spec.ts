import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UsuarioInformacoesComponent } from './usuario-informacoes.component';

describe('UsuarioInformacoesComponent', () => {
  let component: UsuarioInformacoesComponent;
  let fixture: ComponentFixture<UsuarioInformacoesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [UsuarioInformacoesComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(UsuarioInformacoesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
