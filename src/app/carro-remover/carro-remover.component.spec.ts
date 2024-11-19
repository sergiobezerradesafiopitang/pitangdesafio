import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CarroRemoverComponent } from './carro-remover.component';

describe('CarroRemoverComponent', () => {
  let component: CarroRemoverComponent;
  let fixture: ComponentFixture<CarroRemoverComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [CarroRemoverComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CarroRemoverComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
