import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CarrosTodosComponent } from './carros-todos.component';

describe('CarrosTodosComponent', () => {
  let component: CarrosTodosComponent;
  let fixture: ComponentFixture<CarrosTodosComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [CarrosTodosComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CarrosTodosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
