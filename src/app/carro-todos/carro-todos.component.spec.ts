import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CarroTodosComponent } from './carro-todos.component';

describe('CarroTodosComponent', () => {
  let component: CarroTodosComponent;
  let fixture: ComponentFixture<CarroTodosComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [CarroTodosComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CarroTodosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
