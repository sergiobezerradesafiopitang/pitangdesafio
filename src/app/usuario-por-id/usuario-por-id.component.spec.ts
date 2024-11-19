import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UsuarioPorIdComponent } from './usuario-por-id.component';

describe('UsuarioPorIdComponent', () => {
  let component: UsuarioPorIdComponent;
  let fixture: ComponentFixture<UsuarioPorIdComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [UsuarioPorIdComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(UsuarioPorIdComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
