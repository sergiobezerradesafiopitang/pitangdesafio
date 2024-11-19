import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CarroAtualizaComponent } from './carro-atualiza.component';

describe('CarroAtualizaComponent', () => {
  let component: CarroAtualizaComponent;
  let fixture: ComponentFixture<CarroAtualizaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [CarroAtualizaComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CarroAtualizaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
