import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UsuarioRemoverComponent } from './usuario-remover.component';

describe('UsuarioRemoverComponent', () => {
  let component: UsuarioRemoverComponent;
  let fixture: ComponentFixture<UsuarioRemoverComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [UsuarioRemoverComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(UsuarioRemoverComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
